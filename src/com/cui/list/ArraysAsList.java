package com.cui.list;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 9:25
 */
public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        stringList.set(0,"oneList");

        //编译通过，运行出错,因为asList返回的是Arrays的内部类ArrayList，该ArrayList是一个内部类，并没有实现这些方法
        //stringList.add("four");
        //stringList.remove(2);
        //stringList.clear();
        stringList.stream().forEach(x -> System.out.println(x));

        int[] intArray = new int[10];
        Arrays.stream(intArray).forEach(System.out :: println);


        // 判断非null
        Objects.requireNonNull(null);
    }
}
