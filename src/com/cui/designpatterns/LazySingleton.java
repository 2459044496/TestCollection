package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 10:28
 * 懒汉模式--需要时再加载(延迟加载)
 */
public class LazySingleton {
    // volatile关键字防止指令重排
    private volatile static LazySingleton lazySingleton = null;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        // 第一个判断为了效率问题，减少加锁次数
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                // 防止产生多个实例
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
