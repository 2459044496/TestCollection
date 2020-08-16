package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/30 19:03
 * Java是值传递
 * 基本数据类型的值不会改变
 * 引用数据类型会改变
 */
public class Test {
    public static void main(String[] args) throws Exception{
        int i =0;
        change(i);
        System.out.println(i);
        int[] array = new int[10];
        array[0] = 22;
        array[i++] = 111;
        System.out.println(Arrays.toString(array));
        System.out.println(null != null);
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//最小堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 02 - 01;
            }
        });// 最小堆
        minHeap.add(1);
        minHeap.add(10);
        minHeap.add(-3);
        System.out.println(minHeap.peek());
        // Collections  集合工具类
        ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<>();
        map.search(16, (k, v)-> v.equals(10) ? k : null);

    }

    static void change(int i){
        i = 100;
    }

    static void testBitSet() {
        System.out.println("jinrufangfa");
        int n = 200000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n+1);
        int count = 0;
        int i;
        for(i=2; i<=n; i++) {
            b.set(i);
        }
        i = 2;
        while(i * i<=n) {
            if(b.get(i)){
                count++;
                int k = 2 * i;
                while (k<=n) {
                    b.clear(k);
                    k+=i;
                }
            }
            i++;
        }
        while (i<=n) {
            if (b.get(i)) {
                i++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count + "primes");
        System.out.println(end-start);
    }
}
