package com.cui.job;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Desc:Timer实现定时任务
 * @author: Cui Pai
 * @date 2020/8/27 10:52
 * Timer 类实现定时任务的优点是方便，因为它是 JDK 自定的定时任务，
 * 但缺点是任务如果执行时间太长或者是任务执行异常，会影响其他任务调度，
 * 所以在生产环境下建议谨慎使用。
 */
public class TimeTaskTest {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行定时任务，时间：" + new Date());
            }
        };

        Timer timer = new Timer();
        // 延迟一秒，每五秒执行一次
        System.out.println(new Date());
        timer.schedule(timerTask, 1000, 5000);
    }
}
