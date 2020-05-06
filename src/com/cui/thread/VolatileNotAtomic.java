package com.cui.thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 11:34
 */
public class VolatileNotAtomic {

    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i=0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count++;
            }
        }

        while (subtractThread.isAlive()) {}

        System.out.println("count值为" + count);

    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0;i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
            }
        }
    }
}
