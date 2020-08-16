package com.cui.bookreadingfeel.algorithms4th;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/25 17:06
 * 求两个数的最大公约数
 */
public class MaxCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getMaxCommonDivisor(100, 50));
    }

    // 计算两个非负整数的p和q的最大公约数：
    // 若q为0。则最大公约数为p
    // 否则，将p除以q得到余数r，p和q的最大公约数为q和r的最大公约数。
    public static int getMaxCommonDivisor(int p, int q) {
        if (q == 0) {
            return p;
        }
        // 不会堆栈溢出的原因：当参数q为0，会return
        int r = p % q;
        return getMaxCommonDivisor(q, r);
    }
}
