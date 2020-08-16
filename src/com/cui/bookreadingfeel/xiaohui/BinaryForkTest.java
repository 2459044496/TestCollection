package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/31 18:38
 * 二叉树属于完全二叉树
 * 二叉堆  最大堆 最小堆
 * 最大堆的任何一个父节点的值，都大于或等于它左、右孩子节点的值。
 * 最小堆的任何一个父节点的值，都小于或等于它左、右孩子节点的值。
 *
 * 当二叉堆插入节点时，插入位置是完全二叉树的最后一个位置。需要上浮
 *
 * 二叉堆删除节点的过程和插入节点的过程正好相反，所删除的是处于堆顶的节点。
 * 为了继续维持完全二叉树的结构，我们把堆的最后一个节点10临时补到原本堆顶的位置。
 * 需要下沉
 *
 * 构建二叉堆，也就是把一个无序的完全二叉树调整为二叉堆，本质就是让所有非叶子节点依次“下沉”。
 * 时间复杂度：插入、删除O(logn),构建O(n)
 */
public class BinaryForkTest {
    public static void main(String[] args) {

        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println("最小堆上浮");
        System.out.println(Arrays.toString(array));

        array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println("构建最小堆");
        System.out.println(Arrays.toString(array));
        int[] array2 = {1,3,4,56,65,345,65,346,60};
        System.out.println("二分查找法");
        System.out.println(binarySearch(array2, 2));

        /**
         * 堆排序
         * 1. 把无序数组构建成二叉堆。
         * 需要从小到大排序，则构建成最大堆；需要从大到小排序，则构建成最小堆。
         * 2. 循环删除堆顶元素，替换到二叉堆的末尾，调整堆产生新的堆顶。
         */
        int[] arr = new int[] {1,3,2,6,5,9,10,0};
        heapSort(arr);
        System.out.println("堆排序法，使用最大堆，升序");
        System.out.println(Arrays.toString(arr));
    }

    // 二分法
    public static int binarySearch(int[] array, int num) {
        int head = 0;
        int last = array.length-1;
        while (head <= last) {
            int binary = (head + last) / 2;
            if (num > array[binary]) {
                head = binary + 1;
            }
            if (num < array[binary]) {
                last = binary - 1;
            }
            if (num == array[binary]) {
                return binary;
            }
        }
        return -1;
    }

    /**
     * 上浮操作 最小堆
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        // 最后一个节点
        int childIndex = array.length-1;
        // 获取最后一个节点的父节点
        int parentIndex = (childIndex - 1)/2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        // 子节点下标大于0，插入的叶子节点的值大于父节点
        while (childIndex > 0 && temp <array[parentIndex]) {
            // 无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            // 单向赋值后获取新的childIndex和parentIndex
            childIndex = parentIndex;
            parentIndex = (parentIndex -1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     *  下沉调整    最小堆
     * @param array 待调整的堆
     * @param parentIndex   要下沉的父节点
     * @param length    堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp 保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        // 父节点的左子节点
        int childIndex = 2*parentIndex + 1;
        // 如果有子节点就进入循环
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex+1 < length && array[childIndex] > array[childIndex+1]) {
                childIndex++;
            }
            // 如果父节点小于等于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]) {
                return;
            }
            // 无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            // 单向赋值后获取新的childIndex和parentIndex
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建二叉堆 最小堆
     * 通过数组实现二叉堆
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”调整
        for (int i=(array.length-2)/2; i>=0; i--) {
            downAdjust(array, i, array.length);
        }
    }


    /**
     *  下沉调整    最大堆
     * @param array 待调整的堆
     * @param parentIndex   要下沉的父节点
     * @param length    堆的有效大小
     */
    public static void downAdjustMax(int[] array, int parentIndex, int length) {
        // temp 保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        // 父节点的左子节点
        int childIndex = 2*parentIndex + 1;
        // 如果有子节点就进入循环
        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex+1 < length && array[childIndex] < array[childIndex+1]) {
                childIndex++;
            }
            // 如果父节点大于等于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                return;
            }
            // 无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            // 单向赋值后获取新的childIndex和parentIndex
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        System.out.println("rucan"+Arrays.toString(array));

        for (int i=(array.length-2)/2; i>=0; i--) {
            // 1,把无序数组构建成最大堆
            downAdjustMax(array, i, array.length);
            // 最小堆
            //upAdjust(array);
            //downAdjust(array, 0, array.length-1);
        }

        System.out.println("最大堆");
        System.out.println(Arrays.toString(array));
        for (int i=array.length-1; i>0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 继续下沉调整
            downAdjustMax(array, 0, i);
            // 最小堆
            //downAdjust(array, 0, i);
        }
    }
}
