package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:22
 */
public class CarFactoryDemo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar(new AudiCar());
        car.setStartingSpeed();
        car.setTopSpeed();
        car.printCarInfo();
    }
}
