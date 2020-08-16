package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/4 17:54
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,4,6,5,3,8,2,6,1,9};
        quickSort1(array, 0, array.length-1);
        System.out.println("分治双边循环法");
        System.out.println(Arrays.toString(array));
        quickSort2(array, 0, array.length-1);
        System.out.println("分治单边循环法");
        System.out.println(Arrays.toString(array));
        quickSortForStack(array, 0, array.length-1);
        System.out.println("非递归使用栈");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition1(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归
        quickSort1(arr, startIndex, pivotIndex-1);
        quickSort1(arr, pivotIndex+1, endIndex);
    }

    public static void quickSort2(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition2(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归
        quickSort2(arr, startIndex, pivotIndex-1);
        quickSort2(arr, pivotIndex+1, endIndex);
    }

    /**
     * 非递归实现（使用栈）
     * eg
     * 0 10
     * 0 5  7 10
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortForStack(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来替代递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起始下标
        Map rootParam = new HashMap(16);
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件，栈为空
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起始下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置，单边循环
            int pivotIndex = partition2(arr, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 分治（双边循环法）
     * @param arr   待交换的数组
     * @param startIndex    起始下标
     * @param endIndex  结束下标
     * @return  基准元素位置
     */
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以随机）
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针左移
            while (left<right && arr[right]>pivot) {
                right--;
            }
            // 控制left指针右移
            while (left<right && arr[left]<=pivot) {
                left++;
            }
            // 交换left和right指针指向的元素
            if (left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 分治（单边循环法）
     * 首先选定基准元素pivot。同时，设置一个mark指针指向数列起始位置，这个
     * mark指针代表小于基准元素的区域边界。接下来，从基准元素的下一个位置开始遍历数组。
     *
     * 如果遍历到的元素大于基准元素，就继续往后遍历。
     * 如果遍历到的元素小于基准元素，则需要做两件事：第一，把mark指针右移1位，因为小于pivot的区
     * 域边界增大了1；第二，让最新遍历到的元素和mark指针所在位置的元素交换位置，因为最新遍历的元素
     * 归属于小于pivot的区域。
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置作为基准元素（也可以随机）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i=startIndex+1; i<=endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
