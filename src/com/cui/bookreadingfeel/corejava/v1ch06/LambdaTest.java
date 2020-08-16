package com.cui.bookreadingfeel.corejava.v1ch06;

import java.util.Arrays;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/21 18:39
 */
public class LambdaTest {
    /**
     * 1，即使lambda表达式没有参数，仍然要提供空括号就像无参方法一样
     *    () -> { for (int i = 100;i >= 0;i ) System.out.println(i); }
     * 2，如果可以推导出一个lambda表达式的参数类型，则可以忽略其类型
     *    Comparator<String> comp
     *    = (first, second) // Same as (String first, String second)
     *    -> first.lengthO - second.lengthO;
     * 3，如果方法只有一个参数，而且这个参数的类型可以推导得出，那么甚至还可以省略小括号
     *    ActionListener listener = event ->
     *    System.out.println("The time is " + new Date()");
     *    // Instead of (event) -> . . . or (ActionEvent event) -> . . .
     * 4，无需指定lambda表达式的返回类型
     *    (String first, String second) -> first.lengthO - second.length()
     * 5，如果一个lambda表达式只在某些分支返回一个值，而在另外一些分支不返回值，这是不合法的
     *    (int x)-> { if(x >= 0) return 1; }
     * @param args
     */
    public static void main(String[] args) {
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets,String::indexOf);

    }
}
