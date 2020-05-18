package com.cui.bookreadingfeel.javaconcurrencyinpractice.package3;

import java.util.*;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 9:14
 * 不可见的
 * number的值可能为0，也可能循环持续执行下去
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReadThread().start();
        number = 43;
        ready = true;
        HashSet hashSet = new HashSet();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");

        HashSet cloneHashSet = new HashSet();
        cloneHashSet = (HashSet) hashSet.clone();

        cloneHashSet.add("d");
        System.out.println(hashSet);
        System.out.println(cloneHashSet);
        Map<String,String> hashMap = new HashMap<String, String>() {
            {
                put("3","c");
            }
        };
        hashMap.put("1","a");
        hashMap.put("2","b");
        hashMap.remove("3");
        hashMap.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
