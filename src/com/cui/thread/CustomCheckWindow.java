package com.cui.thread;

import java.util.concurrent.Semaphore;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 11:58
 */
public class CustomCheckWindow {

    public static void main(String[] args) {
        // 基于空闲信号的同步
        Semaphore semaphore = new Semaphore(3);

        for (int i =0;  i < 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }

    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客，正在查验中");

                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("No." + seq + "乘客，存在嫌疑，不能出国!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客已完成服务。");
            }
        }
    }
}
