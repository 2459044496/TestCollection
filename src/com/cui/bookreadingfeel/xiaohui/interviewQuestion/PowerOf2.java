package com.cui.bookreadingfeel.xiaohui.interviewQuestion;


/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/6 17:29
 * 判断一个数是否是2的整次幂
 * &运算  如果相对应位都是1，则结果为1，否则为0
 * 4        4-1=3
 * 100      11
 * 100 & 11 = 0
 * 8        8-1=7
 * 1000     111
 * 1000 & 111 = 0
 *
 * 如果n是2的整次幂，那么
 * (n & (n-1)) == 0
 *
 */
public class PowerOf2 {
    public static void main(String[] args) {
        int n = 321;
        if ((n & (n-1)) == 0) {
            System.out.println(n + "是2的整次幂");
        } else {
            System.out.println(n + "不是2的整次幂");
        }
    }
}
