package com.cui.bookreadingfeel.xiaohui.interviewQuestion;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/6 17:07
 * 最大公约数
 * ==比的是值   只是引用数据类型存放的是内存地址
 * 基本数据类型只能通过==比较，没有方法
 */
public class MaxCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV2(25, 10));
        System.out.println(getGreatestCommonDivisorV3(25, 10));

    }

    /**
     * 辗转相除法， 又名欧几里得算法（Euclidean algorithm）
     * 两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * 例如10和25，25除以10商2余5，那么10和25的最大公约数，等同于10和5的最大公约数。
     * 直到两个数可以整除，或者其中一个数减小到1为止。
     *
     * 当两个整数较大时，做a%b取模运算的性能会比较差。这
     * @return
     */
    public static int getGreatestCommonDivisorV2(int a, int b) {
        int big = a>b ? a:b;
        int small = a<b? a:b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV2(big%small, small);
    }

    /**
     * 更相减损术
     * 两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。
     * 例如10和25，25减10的差是15，那么10和25的最大公约数，等同于10和15的最大公约数。
     * 直到两个数可以相等为止，最大公约数就是最终相等的这两个数的值。
     * 更相减损术是不稳定的算法，当两数相差悬殊时，如计算10000和1的最大公约数，就要递归9999次！
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b? a:b;
        return getGreatestCommonDivisorV3(big-small, small);
    }
}
