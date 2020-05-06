package com.cui.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 13:47
 */
public class UserRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected." + executor.toString());
    }
}
