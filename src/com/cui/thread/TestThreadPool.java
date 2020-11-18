package com.cui.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/9/20 19:47
 */
public class TestThreadPool {
    public static void main(String[] args) {
        doJobs();
        doJobs();
    }

    public static void doJobs() {
        ExecutorService executors = Executors.newFixedThreadPool(6);
        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("执行任务1");
                    Thread.sleep(3000);
                    System.out.println("任务1结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("执行任务2");
                    Thread.sleep(3000);
                    System.out.println("任务2结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("执行任务3");
                    Thread.sleep(30000);
                    System.out.println("任务3结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 不在接受新的线程
        executors.shutdown();

        while (true) {
            if (executors.isTerminated()) {
                System.out.println("线程池执行完成");
                break;
            }
        }

    }
}
