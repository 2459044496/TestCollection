package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/30 10:18
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        //System.out.println(Arrays.toString(insertArray(array, 10, 3)));
        System.out.println(Arrays.toString(deleteArray(array,3)));
    }

    public static int[] insertArray(int[] array, int ele, int index) {
        int[] newArray = Arrays.copyOf(array, array.length+1);
        for (int i = array.length-1; i>=index; i--) {
            // 数组元素后移
            newArray[i+1] = array[i];
        }
        newArray[index] = ele;
        return newArray;
    }

    public static int[] deleteArray(int[] array, int index) {

        for (int i=index; i<array.length-1; i++) {
            // 数组元素前移
            array[i] = array[i+1];
        }
        return array;
    }
}
