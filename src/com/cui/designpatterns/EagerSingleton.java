package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 10:25
 * eager    急于
 * 饥汉模式--类加载时就初始化
 */
public class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    // 私有构造方法，防止通过new初始化
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

}
