package com.cui.map;

import java.util.HashMap;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 9:51
 */
public class HashMapEndLessLoop {

    private static HashMap<Long,EasyCoding> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for(int i =0; i < 100000; i++) {
            Thread.sleep(50);
            (new Thread() {
                @Override
                public void run() {
                    map.put(System.nanoTime(),new EasyCoding());
                }
            }).start();
        }
    }
}
