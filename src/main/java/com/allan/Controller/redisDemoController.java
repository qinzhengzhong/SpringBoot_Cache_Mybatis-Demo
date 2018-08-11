package com.allan.Controller;

import com.allan.service.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis demo
 */
@RestController
public class redisDemoController {
    private final Logger logger = LoggerFactory.getLogger(redisDemoController.class);
    @Autowired
    private RedisService redisService;

    private static  final String  KEY = "allan";


    @GetMapping(value = "/redis/setTest")
    public void demoTest(){
        redisService.set(KEY,"redis demo test");
        logger.info("保存到redis中完成****************");
    }


    @GetMapping(value = "/redis/getTest")
    public String getTest(){
        String key= (String) redisService.get(KEY);
        logger.info("********from redis key********"+key);
        return key;
    }

    @GetMapping(value = "/redis/delectKey")
    public void delectKey(){
        redisService.remove(KEY);
        logger.info("********delect redis key********");

    }
}
