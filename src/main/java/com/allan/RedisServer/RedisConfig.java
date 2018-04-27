package com.allan.RedisServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;


@Configuration
@EnableCaching//启用缓存，这个注解很重要；
//继承CachingConfigurerSupport，为了自定义生成KEY的策略。可以不继承。
public class RedisConfig extends CachingConfigurerSupport {

    private  final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    //因为生产环境和开发环境使用不同的启动资源文件，所以使用了@Profile，用来指定使用的启动资源文件
    @Configuration
    @Profile(value={"dev"})//如果你不需要的话可以删掉
    static class LocalConfiguration {
        //从application.properties中获得以下参数
        @Value("${redis.host}")
        private String host;
        @Value("${redis.port}")
        private Integer port;
        @Value("${redis.password}")
        private String password;

        /**
         * 缓存管理器.
         * @param redisTemplate
         * @return
         */
        @Bean
        public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
            CacheManager cacheManager = new RedisCacheManager(redisTemplate);
            return cacheManager;
        }
        @Bean
        public RedisTemplate<Serializable, Serializable> redisTemplate(
                JedisConnectionFactory redisConnectionFactory) {

            RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
            //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
            //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现 ObjectRedisSerializer
            //或者JdkSerializationRedisSerializer序列化方式;
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setHashKeySerializer(new StringRedisSerializer());
            redisTemplate
                    .setValueSerializer(new JdkSerializationRedisSerializer());
            redisTemplate
                    .setHashValueSerializer(new JdkSerializationRedisSerializer());
            //以上4条配置可以不用
            redisTemplate.setConnectionFactory(redisConnectionFactory);
            return redisTemplate;
        }

        @Bean
        public JedisConnectionFactory redisConnectionFactory() {
            JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
            redisConnectionFactory.setHostName(host);
            redisConnectionFactory.setPort(port);
            redisConnectionFactory.setPassword(password);

            return redisConnectionFactory;
        }
    }


}
