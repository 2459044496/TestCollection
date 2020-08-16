package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/1 17:42
 * 冒泡排序
 * 每次排序都将最大的后移，所以内层循环等于 数组长度-1-外层循环次数
 * (n-1)+(n-2)+…2+1=[(1+(n-1))(n-1)]/2=(n(n-1))/2=(n²-n)/2=n²/2-n/2
 * 所以时间复杂度为n^2  最优次数为n-1,时间复杂度n
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] array = {2,6,3,4,6,10,16,18};
        bubbleSort3(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 数组的后半部分可能是排序好的（升序）   例如34215678
     * @param array
     */
    public static void bubbleSort3(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数组的边界，每次比较只需要比到这里
        int sortBorder = array.length -1;
        for (int i=0; i<array.length-1; i++) {
            // 在某些情况下，不循环所有遍就可以排序完成，主要看是否有元素交换
            // 有序标记
            boolean isSorted = true;
            for (int j=0; j<sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 因为有元素交换，所以不是有序的
                    isSorted = false;
                    // 更新为最后一次元素交换的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 在某些情况下，不循环所有遍就可以排序完成，主要看是否有元素交换
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            // 在某些情况下，不循环所有遍就可以排序完成，主要看是否有元素交换
            // 有序标记
            boolean isSorted = true;
            for (int j=0; j<array.length-1-i; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 因为有元素交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }


    /**
     * 共循环数组长度-1次
     * 外层循环一次，内层循环就少一次
     * @param array
     */
    public static void bubbleSort1(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            for (int j=0; j<array.length-1-i; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
