package com.cui.bookreadingfeel.understandjvm;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/21 15:04
 */
public class JavaByteCodeTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        new JavaByteCodeTest().add(a, b);
        add1(a, b);
    }

    // 非静态方法的局部变量表的第一个Slot为this，下标为0
    private int add(int a, int b) {
        return a+b;
    }

    private static int add1(int a, int b) {
        return a+b;
    }
}
