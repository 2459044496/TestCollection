package com.cui.compara;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 14:12
 * 不同的类的equals方法实现各不相同，要根据源码判断
 * 如：ArraysList的equals只进行了是否为List子类的判断
 */
public class ListEquals {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        if (arrayList.equals(linkedList)) {
            System.out.println("equals is true");
        } else {
            System.out.println("equals is false");
        }
    }
}
