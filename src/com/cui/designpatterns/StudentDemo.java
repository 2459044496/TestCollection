package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:50
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder(170,120,1)
                .setAge(18).builderStudent();
        Student student2 = new Student.StudentBuilder(170,120,1)
                .setAge(18).setColor(22).builderStudent();
        Student student3 = new Student.StudentBuilder(170,120,1)
                .setAge(18).setColor(33).setHasGlasses(5).builderStudent();
        System.out.println(student);
        System.out.println(student2);
        System.out.println(student3);
    }
}
