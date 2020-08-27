package com.cui.job;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:使用ScheduledExecutorService执行定时任务
 * @author: Cui Pai
 * @date 2020/8/27 10:59
 * 在单机生产环境下建议使用 ScheduledExecutorService 来执行定时任务，
 * 它是 JDK 1.5 之后自带的 API，因此使用起来也比较方便，
 * 并且使用 ScheduledExecutorService 来执行任务，不会造成任务间的相互影响。
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Run Schedule: " + new Date());
        }, 1, 3, TimeUnit.SECONDS);
        // 1s后开始执行，每3s执行一次
    }
}
