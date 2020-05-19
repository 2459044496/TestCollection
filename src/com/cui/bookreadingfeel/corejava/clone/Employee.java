package com.cui.bookreadingfeel.corejava.clone;

import java.util.Date;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/19 19:33
 */
public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    // 1,将clone()访问权限由protected更改为public
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 2,调用父类的clone方法
        Employee cloned = (Employee) super.clone();
        // 3,调用可变类的clone方法
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
