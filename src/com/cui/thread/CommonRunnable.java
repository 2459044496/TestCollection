package com.cui.thread;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/9/19 16:16
 */
public class CommonRunnable implements Runnable{
    private int count = 100;

    @Override
    public void run() {
        while (count > 1) {
            count--;
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "count:" + count);
        }
    }
}
