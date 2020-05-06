package com.cui.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 11:49
 */
public class TranslateThread extends Thread {

    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        // 在某种情况下，这里会抛出异常
        if (Math.random() > 0.5) {
            throw new RuntimeException("源文件存在非法字符");
        }

        System.out.println(content + "翻译完成，译文为。。。");
        count.countDown();
    }
}
