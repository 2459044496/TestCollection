package com.cui.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 13:49
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);

        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectedExecutionHandler handler = new UserRejectedExecutionHandler();

        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(
                1, 2, 60, TimeUnit.SECONDS,
                queue, f1, handler
        );
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(
                1, 2, 60, TimeUnit.SECONDS,
                queue, f2, handler
        );

        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
