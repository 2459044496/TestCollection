package com.cui.java8;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/19 18:52
 * Java8新增的默认方法，可以不覆写，或有选择的覆写
 */
public class InterfaceDefaultMethodTest implements InterfaceDefaultMethod {
    @Override
    public void method1() {

    }
    /**
     * 解决默认方法冲突
     * 1，超类优先（一个超类，一个接口）
     * 2，接口冲突
     *      （多个接口）实现的两个接口方法冲突，必须覆写方法，解决二义性    接口名.super.方法名()
     *      只考虑超类（一个超类，多个接口）
     * 不要让默认方法重新定义Object类中的某个方法，因为“类优先”规则，没有意思，所有类的超类都是Object
     */
}
