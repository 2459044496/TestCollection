package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/30 14:46
 * 以数组的方式实现链表
 * 以链表也可以实现
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.output();
        System.out.println(stackTest.pop());
        System.out.println(stackTest.pop());
    }

    int[] array = new int[10];
    int size = 0;

    public void push(int i) {
        if (size == array.length+1) {
            array = Arrays.copyOf(array, array.length*2);
        }
        array[size] = i;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int num = array[size-1];
        size--;
        return num;
    }

    public void output() {
        for (int i: array) {
            System.out.println(i);
        }
    }

}
