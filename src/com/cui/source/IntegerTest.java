package com.cui.source;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/7 16:03
 */
public class IntegerTest {

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    public static void main(String[] args) {
        System.out.println(Integer.toString(10,2));
        System.out.println(Integer.toString(10,8));
        System.out.println(Integer.toString(10,10));
        System.out.println(Integer.toString(10,16));


        System.out.println( 342646 - (3426 * 100));
        System.out.println(stringSize(100));


        System.out.println("=====");
        System.out.println(-10%-2);
        System.out.println(-10/-2);
        System.out.println(-5%2);
        System.out.println(-5/2);

        System.out.println(Integer.toUnsignedString(10,2));
        char[] chars = new char[]{0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0};
        System.out.println(new String(chars,7,0).length());
        System.out.println(-1>>>1);
        System.out.println("-1".toCharArray());
        System.out.println(Math.min(4,4));
        System.out.println(((long) 10) & 0xffffffffL);
        long long1L = 10;
        System.out.println(long1L & 0xffffffffL);
        System.out.println(0b1010);
        System.out.println(Integer.toUnsignedLong(100));
        int int1 = 100;
        int int2 = 6553600;
        System.out.println(Integer.toHexString(int1));
        System.out.println(int1 <<= 16);
        System.out.println(int1 >>>= 31);
        System.out.println(Integer.numberOfLeadingZeros(100));

        System.out.println(Integer.toUnsignedString(12));
        System.out.println('+'<'0');
        System.out.println('-'<'0');
        System.out.println((int)'0');
        System.out.println((int)'+');
        System.out.println((int)'-');



        System.out.println(getProperties(8));
        System.out.println(-21478364 / 10);
    }

    // Requires positive x
    // 需要使用正数
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }


    static final int A[] = new int[256];
    static int getProperties(int ch) {
        char offset = (char)ch;
        int props = A[offset];
        return props;
    }
}
