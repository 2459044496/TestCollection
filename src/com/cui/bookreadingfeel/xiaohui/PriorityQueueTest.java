package com.cui.bookreadingfeel.xiaohui;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/1 15:57
 * 最大优先队列
 *
 * 1. 最大堆的堆顶是整个堆中的最大元素。
 * 2. 最小堆的堆顶是整个堆中的最小元素。
 * 因此，可以用最大堆来实现最大优先队列，这样的话，每一次入队操作就是堆的插入操作，每一次出
 * 队操作就是删除堆顶节点。
 *
 * Java的优先队列PriorityQueue
 */
public class PriorityQueueTest {

    public static void main(String[] args) throws Exception {
        PriorityQueueTest priorityQueueTest = new PriorityQueueTest();
        priorityQueueTest.enQueue(1);
        priorityQueueTest.enQueue(10);
        priorityQueueTest.enQueue(5);
        priorityQueueTest.enQueue(8);
        System.out.println("出队元素: " + priorityQueueTest.deQueue());
        System.out.println("出队元素: " + priorityQueueTest.deQueue());
    }

    private int[] array;
    private int size;
    public PriorityQueueTest(){
        // 队列初始化长度
        array = new int[32];
    }

    /**
     * 入队
     * @param key   入队元素
     */
    public void enQueue(int key) {
        if (size >=  array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("Queue is null!");
        }
        // 获取堆顶元素
        int head = array[0];
        // 让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }



    /**
     * 上浮操作
     */
    private void upAdjust() {
        // 最后一个节点
        int childIndex = size-1;
        // 获取最后一个节点的父节点
        int parentIndex = (childIndex - 1)/2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            // 无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex/2;
        }
        array[childIndex] = temp;
    }

    /**
     *  下沉调整
     */
    private void downAdjust() {
        // temp 保存父节点值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex+1 < size && array[childIndex] < array[childIndex+1]) {
                childIndex++;
            }
            // 如果父节点大于等于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            // 无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = temp;
    }

    // 队列扩容，翻倍
    private void resize() {
        this.array = Arrays.copyOf(this.array, this.size*2);
    }
}
