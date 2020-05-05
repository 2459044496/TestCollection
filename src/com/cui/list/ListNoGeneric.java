package com.cui.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 9:49
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(12));
        a1.add(new String("Hello"));

        List<Integer> a3 = a1;
        System.out.println(a3.toString());

        // 不能添加元素，可以remove和clear
        List<?> a4 = a1;
        a4.remove(0);
        a4.clear();
        //a4.add("23");
    }
}
