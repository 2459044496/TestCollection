package com.cui.thread;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/9/19 17:13
 */
public class TestRunnable {
    public static void main(String[] args) {
        // 测试共享Runnable对象
        CommonRunnable commonRunnable = new CommonRunnable();
        new Thread(commonRunnable).start();
        new Thread(commonRunnable).start();
        new Thread(commonRunnable).start();

    }
}
