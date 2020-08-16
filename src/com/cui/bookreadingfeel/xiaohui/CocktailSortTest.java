package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/1 18:26
 * 鸡尾酒排序        场景：是大部分元素已经有序的情况
 * 第一次从左往右            最大的在最右边
 * 第二次从右往左        最小的在最左边
 * 。。。
 */
public class CocktailSortTest {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,7,8,9,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int temp = 0;
        // 两个内循环，所以/2
        for (int i=0; i<array.length/2; i++) {
            // 有序标记
            boolean isSorted = true;
            // 奇数轮，从左到右比较和交换
            for (int j=i; j<array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 有元素交换
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 在偶数轮之前，重新标记
            isSorted = true;
            // 偶数轮，从右到左比较和交换
            for (int j =array.length-i-1; j>i; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    // 有元素交换
                    isSorted =false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
