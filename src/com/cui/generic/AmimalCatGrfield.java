package com.cui.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 10:03
 * 取数据采用<? extends T>
 * 放数据采用<? super T>
 */
public class AmimalCatGrfield {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());

        // 下行编译出错，只能赋值Cat或Cat子类的集合
        //List<? extends Cat> extendsCatFromAnimal = animals;
        List<? super Cat> superCatFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superCatFromCat = cats;

        List<? extends Cat> extendsCatFromGarfield = garfields;
        // 下行编译出错，只能赋值Cat或Cat的父类
        //List<? super Cat> superCatFromGarfield = garfields;

        // 下三行均编译出错，<? extends T>无法进行add操作
        //extendsCatFromCat.add(new Animal());
        //extendsCatFromCat.add(new Cat());
        //extendsCatFromCat.add(new Garfield());

        // 下行编译出错，只能添加Cat或Cat子类的集合
        //superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        // 所以的super操作能够返回元素，但是泛型丢失，只能返回Object对象
        Object cat = superCatFromCat.get(0);

        Object catExtends2 = extendsCatFromCat.get(0);
        Cat catExtends1 = extendsCatFromCat.get(0);
        // 下行编译出错，虽然Cat集合从Carfield赋值而来，但类型擦除后，是不知道的
        //Garfield garfield1 = extendsCatFromGarfield.get(0);

    }
}
