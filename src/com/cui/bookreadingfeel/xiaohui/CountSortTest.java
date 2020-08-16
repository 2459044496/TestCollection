package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/5 15:16
 * 计数排序
 * 它适用于一定范围内的整数排序。
 * 不适应的情况：
 * 1. 当数列最大和最小值差距过大时，并不适合用计数排序。
 * 2. 当数列元素不是整数时，也不适合用计数排序。
 */
public class CountSortTest {
    public static void main(String[] args) {
        int[] array = {2,34,456,76,7,34,556,4,254,5646,34,4,5,43};
        int[] sortArray1= sort(array);
        System.out.println(Arrays.toString(sortArray1));
        int[] array2 = {90,93,91,95,95,97,92};
        int[] sortArray2 = countSort(array2);
        System.out.println(Arrays.toString(sortArray2));
    }

    public static int[] sort(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        // 没有必要从0开始
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[max+1];
        //3.遍历数列，填充统计数组
        for (int i=0; i<array.length; i++) {
            countArray[array[i]]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i=0; i<countArray.length; i++) {
            for (int j=0; j<countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 优化计数排序
     * 代码第1、2、4步都涉及遍历原始数列，运算量都是n，第3步遍历统计数列，运
     * 算量是m，所以总体运算量是3n+m，去掉系数，时间复杂度是O(n+m)。
     * 至于空间复杂度，如果不考虑结果数组，只考虑统计数组大小的话，空间复杂度
     * 是O(m)。
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素的个数
        int[] countArray = new int[d+1];
        for (int i=0; i<array.length; i++) {
            countArray[array[i]-min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和,从统计数组的第二个元素开始
        for (int i=1; i<countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for(int i=array.length-1;i>=0;i--) {
            sortedArray[countArray[array[i]-min]-1]=array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }
}
