package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:03
 */
public abstract class Car{
    // 起始速度
    protected int startingSpeed;
    // 最高速度
    protected int topSpeed;

    // 修改起始速度
    abstract void setStartingSpeed();
    // 修改最高速度
    abstract void setTopSpeed();

    public void printCarInfo() {
        System.out.println("car startingSpeed: " + startingSpeed + "\n car topSpeed" + topSpeed);
    }
}
