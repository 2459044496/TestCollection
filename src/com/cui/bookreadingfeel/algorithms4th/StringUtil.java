package com.cui.bookreadingfeel.algorithms4th;

import com.sun.istack.internal.NotNull;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/28 14:46
 */
public class StringUtil {
    public static void main(String[] args) {
        String palindrome = "abcdedcba";
        boolean isPalindrome = isPalindrome(palindrome);
        System.out.println(isPalindrome);


    }

    /**
     * 判断一个字符串是否是回文串
     * @param s
     * @return
     * 1    3   5   7   5   3   1
     * 下标
     * s[0] =  s[length-1] ?    length-1-0
     * s[1] =  s[length-2] ?    length-1-1
     * s[2] =  s[length-3] ?    length-1-2
     * s[n] =  s[length-1-n]    length-1-n
     */
    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if (s.charAt(i) != s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 翻转数组
     * @param array
     * @return
     */
    public static int[] flipArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size/2; i++) {
            int temp = array[i];
            array[i] = array[size-1-i];
            array[size-1-i] = temp;
        }
        return array;
    }


}
