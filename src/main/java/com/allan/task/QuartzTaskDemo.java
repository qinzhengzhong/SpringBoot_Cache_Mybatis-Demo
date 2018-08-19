package com.allan.task;

import com.allan.Util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot 定时任务demo
 */
@Component
public class QuartzTaskDemo {

    private static final Logger LOGGER =  LoggerFactory.getLogger(QuartzTaskDemo.class);

    /**
     * 方法一：
     *   使用cron 表达式
     * 每30秒启动
     */
    @Scheduled(cron = "*/30 * * * * ?")
    public void timerToNow(){
        LOGGER.info("》》》》使用cron 表达式，现在时间:" + DateUtil.getDateNow("yyyy-MM-dd hh:mm:ss"));
    }


    /**
     * 方法二：
     *  使用Rate/Delay表达式（毫秒值）：
     *　　@Scheduled(fixedRate = 6000)：上一次开始执行时间点后每隔6秒执行一次。
     *　　@Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后6秒再执行。
     *　　@Scheduled(initialDelay=1000, fixedRate=6000)：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次。
     *
     */
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        LOGGER.info("》》》》》使用Rate/Delay表达式，现在时间：" + DateUtil.getDateNow("yyyy-MM-dd hh:mm:ss"));
    }
}
