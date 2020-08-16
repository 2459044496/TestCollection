package com.cui.bookreadingfeel.algorithms4th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/25 17:33
 */
public class FlipArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(flipArray(array)));
        int i =10;
        System.out.println(update(10));
        // 方法不能修改一个基本类型的参数
        // 可以改变对象参数的状态，不能让对象参数引用一个新的对象
        System.out.println(i);
        int[] ii = {0,10,100};
        System.out.println(Arrays.toString(update2(ii)));
        System.out.println(Arrays.toString(ii));
        System.out.println(Arrays.toString(update3(ii)));
        System.out.println(Arrays.toString(ii));
        int a = 0;// 局部变量需要赋初始值
        System.out.println(a);

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.intern() == s2.intern());
        long aaa = Runtime.getRuntime().maxMemory() /1000 / 1000;
        System.out.println(aaa);
        List<String> list = new ArrayList<>();
        int iii = 0;
        while (true) {
            list.add(String.valueOf(iii++).intern());
        }

    }

    // 翻转数组
    public static int[] flipArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size/2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        return array;
    }

    public static int update(int i) {
        i = 100;
        return i;
    }

    public static int[] update2(int[] i) {
        i[0] = 1000;
        return i;
    }

    public static int[] update3(int[] i) {
        i = new int[]{1, 2, 3};
        return i;
    }
}
