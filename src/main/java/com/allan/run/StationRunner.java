package com.allan.run;

import com.allan.entity.StationInfo;
import com.allan.mapper.StationInfoMapper;
import com.allan.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 项目启动加载车站信息到缓存
 * @Auther: qinzhengzhong
 * @Date: 2021/1/17 11:24
 * @Description:
 */
@Slf4j
@Order(value=1)
//@Component
public class StationRunner implements CommandLineRunner {

    @Autowired
    private StationInfoMapper stationInfoMapper;
    @Autowired
    private RedisService redisUtil;

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>>>>>>>开始加载车站缓存<<<<<<<<<<<");
        List<StationInfo> list = stationInfoMapper.getAllStations();
        for (StationInfo stationInfo : list) {
            redisUtil.add(stationInfo.getId(),stationInfo);
        }
        log.info(">>>>>>>>>>加载车站信息完毕共计：{}条<<<<<<<<<<<",list.size());
    }
}
