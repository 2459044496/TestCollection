package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:06
 */
public class JeepCar extends Car {

    @Override
    void setStartingSpeed() {
        startingSpeed = 10;
    }

    @Override
    void setTopSpeed() {
        topSpeed = 150;
    }
}
