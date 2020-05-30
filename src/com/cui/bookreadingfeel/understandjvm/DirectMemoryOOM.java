package com.cui.bookreadingfeel.understandjvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/19 15:21
 * 使用unsafe分配本机内存
 * -Xmx20M
 * -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
