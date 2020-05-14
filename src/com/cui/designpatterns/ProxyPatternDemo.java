package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 10:55
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        // 不知道实际对象的存在
        Image image = new ProxyImage("test.img");
        image.diplay();
    }
}
