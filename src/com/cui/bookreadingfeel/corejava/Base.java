package com.cui.bookreadingfeel.corejava;

import java.util.Arrays;

import static java.lang.Math.*;
/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/14 16:12
 */
public class Base {
    public static void main(String[] args) {
        double nantest = 0;
        System.out.println("is NaN? " + Double.isNaN(nantest));// 使用isNaN()判断，不能使用 ==
        System.out.println("二进制后从右往左第四位是0返回1 ：" + (843 & 8) / 8);// 从右往左第四位是0返回1
        System.out.println(1 << 35);
        System.out.println(1 << 3); // 除非 << 运算符左边是long类型，对右侧参数进行模64，其他数据类型都进行模32
        System.out.println(2.0-1.1);// 无法准确表示，就像10进制无法表示1/3，应该使用BigDecima类
        System.out.println(PI);
        System.out.println(E);
        System.out.println("平方根：" + sqrt(100));
        System.out.println("幂运算：" + pow(10,3));
        System.out.println("自然数底数e的参数次方：" + exp(2));
        System.out.println("参数的自然数底数的对数值：" + log(100));
        double radians = 30;
        // toRadians()将double转为弧度
        System.out.println("cos值: " + cos(toRadians(radians)));
        System.out.println("sin值: " + sin(toRadians(radians)));
        // 基础数据类型进行运算时，有double转double，有float转float，有long转long，否则都转int
        // byte->short  short->int  int->long   char->int   int->double,转换无丢失
        // int-> float  long->float long->double,精度丢失
        // ?=   =   +=  -=  *=  /=  %=  &=  |=  ^=  <<= >>= >>>=从右往左运算

        // 多维数组
        int[][] magicSquare =
                {
                        {16,3,2,34},
                        {435,54,2,3},
                        {45,657,98,67}
                };
        System.out.println("打印二维数组：" + Arrays.deepToString(magicSquare));
        
    }
}
