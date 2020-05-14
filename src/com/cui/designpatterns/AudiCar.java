package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:07
 */
public class AudiCar extends Car{
    @Override
    void setStartingSpeed() {
        startingSpeed = 30;
    }

    @Override
    void setTopSpeed() {
        topSpeed = 200;
    }
}
