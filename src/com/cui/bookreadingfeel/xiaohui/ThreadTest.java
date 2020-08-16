package com.cui.bookreadingfeel.xiaohui;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static int i = 0;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getState()); // 线程当前状态
                System.out.println(Thread.currentThread().isInterrupted()); // 线程是否被终止
                System.out.println(Thread.currentThread().getName());
                for(i=0; i<100; i++) {
                    System.out.println("Thread1:" + i);
                }
            }
        });
        thread1.setName("cui's Thread1"); // 设置线程名字
        //thread1.setDaemon(true); // 设置守护线程
        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for(i=0; i<100; i++) {
                    System.out.println("Thread2:" + i);
                }
            }
        });
        thread1.start();
        //thread2.start();

        ReentrantLock reentrantLock = new ReentrantLock();// 默认非公平锁，传入参数true为公平锁
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();// 条件对象
        condition.await();// 阻塞
        condition.signalAll();// 重新激活
        reentrantLock.unlock();
    }
    
}