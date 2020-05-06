package com.cui.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 13:44
 */
public class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running" + count.getAndIncrement());
    }
}
