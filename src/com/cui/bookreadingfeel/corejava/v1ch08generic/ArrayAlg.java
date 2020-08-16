package com.cui.bookreadingfeel.corejava.v1ch08generic;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/22 15:00
 */
public class ArrayAlg {

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 1; i< a.length; i++) {
            // 根据字符串首字母大小排序
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
