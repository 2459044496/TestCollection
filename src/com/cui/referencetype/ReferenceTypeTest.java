package com.cui.referencetype;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 15:18
 * Strong Reference 强引用
 * Soft Reference   软引用
 * Weak Reference   弱引用
 * Phantom Reference虚引用
 */
public class ReferenceTypeTest {

    public static void main(String[] args) {
        House seller = new House();
        seller = null;
        // 强引用  永久有效
        House buyer1 = seller;
        // 软引用  内存不足
        SoftReference<House> buyer2 = new SoftReference<>(seller);
        // 弱引用  再次YGC
        WeakReference<House> buyer3 = new WeakReference<>(seller);
        // 虚引用  即时失效
        PhantomReference<House> buyer4 = new PhantomReference<>(seller,null);

        /**
         * 测试软引用
         */
        List<SoftReference> houses = new ArrayList<>();

        int i = 0;
        while (true) {

            SoftReference<House> softReference = new SoftReference<>(new House());
            houses.add(softReference);

            System.out.println("i=" + (++i));
        }
    }

}
