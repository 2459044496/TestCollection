package com.cui.bookreadingfeel.understandjvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/31 10:15
 */
public class StringPoolTest {
    public static void main(String[] args) {
        long aaa = Runtime.getRuntime().maxMemory()/1000/1000;
        System.out.println(aaa);
/*        for (int i=0; i<1000000000; i++) {
            String.valueOf(i).intern();
        }*/
        // jdk1.7后常量池在堆
        List<String> list = new ArrayList<>();
        int iii = 0;
        while (true) {
            list.add(String.valueOf(iii++).intern());
        }
    }
}
