package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 10:53
 */
public class ProxyImage implements Image{
    // 通过实际对象的引用来调用
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void diplay() {
        if (realImage == null) {
            // 实例化实际对象
            realImage = new RealImage(fileName);
        }
        // 调用实际对象方法
        realImage.diplay();
    }
}
