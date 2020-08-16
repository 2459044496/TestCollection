package com.cui.bookreadingfeel.xiaohui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/5 16:02
 * 桶排序  可以看作对计数排序的优化
 * 每一个桶（bucket）代表一个区间范围，里面可以承载一个或多个元素。
 * 第1步，就是创建这些桶，并确定每一个桶的区间范围。区间跨度 = （最大值-最小值）/ （桶的数量 - 1）
 * 第2步，遍历原始数列，把元素对号入座放入各个桶中。
 * 第3步，对每个桶内部的元素分别进行排序（显然，只有第1个桶需要排序）。
 * 第4步，遍历所有的桶，输出所有元素。
 */
public class BucketSortTest {
    public static void main(String[] args) {
        double[] array = {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static double[] bucketSort(double[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        // 2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i=0; i<bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        //3.遍历原始数组，将每个元素放入桶中
        for(int i = 0; i < array.length; i++){
            int num = (int)((array[i] - min) * (bucketNum-1) / d);
            bucketList.get(num).add(array[i]);
        }

        //4.对每个桶内部进行排序
        for(int i = 0; i < bucketList.size(); i++){
            //JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                sortedArray[index] = element;
                index++;
                }
            }
        return sortedArray;
    }

}
