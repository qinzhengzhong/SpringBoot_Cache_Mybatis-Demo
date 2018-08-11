package com.allan.service.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于redis分布式锁：
 * 1 互斥性。在任意时刻，只有一个客户端能持有锁。
 * 2 不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。
 * 3 具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。
 * 4 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。
 */
@Service
public class RedisLockService implements Lock{
    private final Logger logger = LoggerFactory.getLogger(RedisLockService.class);

    /**
     * redis 客戶端连接工具
     */
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    /**
     * 唯一key值
     */
    private static final String LOCK_KEY = "redis:lockTest";
    /**
     * SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * 意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定。
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    /**
     * 过期时间
     */
    private static final int  TIMEOUT  = 3000;

    /**
     * redis lua脚本
     */
    private   String script="if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
    /**
     * 线程级变量
     */
    ThreadLocal<String> threadLocal=new ThreadLocal<String>();


    @Override
    public void lock() {
        if (!tryLock()){
            try {
                Thread.sleep(new Random().nextInt(10)+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock();
        }
    }

    @Override
    public boolean tryLock() {
        //获取redis原始连接
        Jedis jedis=(Jedis)jedisConnectionFactory.getConnection().getNativeConnection();

        String uuid= UUID.randomUUID().toString();//生产随机值（必须）
        threadLocal.set(LOCK_KEY);//线程变量传值
        /**
         * 获得连接后，通过连接获得setnx命令：
         * 第一个为key，我们使用key来当锁，因为key是唯一的。
         * 第二个为value，我们传的是requestId，很多童鞋可能不明白，有key作为锁不就够了吗，为什么还要用到value？原因就是我们在上面讲到可靠性时，
         *    分布式锁要满足第四个条件解铃还须系铃人，通过给value赋值为requestId，我们就知道这把锁是哪个请求加的了，在解锁的时候就可以有依据。
         *   requestId可以使用UUID.randomUUID().toString()方法生成。
         * 第三个为nxxx，这个参数我们填的是NX，意思是SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；
         * 第四个为expx，这个参数我们传的是PX，意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定。
         * 第五个为time，与第四个参数相呼应，代表key的过期时间。
         *
         *
         *
         * 1. 当前没有锁（key不存在），那么就进行加锁操作，并对锁设置个有效期，同时value表示加锁的客户端。
         * 2. 已有锁存在，不做任何操作。
         */
        String ret= jedis.set(LOCK_KEY,uuid , SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME,TIMEOUT);
        if (StringUtils.isNotBlank(ret) && ret.equals("ok")){
            logger.info("***********redis 加锁成功*******");
            return true; //加锁成功，返回
        }
        return false;
    }

    @Override
    public void unlock() {
        try {
            /**
             * 读取lua脚本配置文件
             */
            File file = ResourceUtils.getFile("classpath:unlock.lua");
            /**
             * 获取Redis连接
             */
            Jedis jedis=(Jedis)jedisConnectionFactory.getConnection().getNativeConnection();
            /**
             * 执行lua脚本
             */
            jedis.eval(script, Arrays.asList(LOCK_KEY),Arrays.asList(threadLocal.get()));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("找不到解锁文件,解锁失败。。。。");
        }

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
