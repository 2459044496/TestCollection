package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 10:49
 * 实际对象
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void diplay() {
        System.out.println("RealDisplay: " + fileName);
    }

    public void loadFromDisk() {
        System.out.println("loading: " + fileName);
    }
}
