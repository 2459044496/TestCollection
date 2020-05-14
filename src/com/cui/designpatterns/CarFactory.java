package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:15
 */
public class CarFactory {
    public Car getCar(Car car) {
        if (car instanceof AudiCar) {
           return new AudiCar();
        }
        else if (car instanceof JeepCar) {
            return new JeepCar();
        }
        return car;
    }
}
