package com.cui.designpatterns;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/13 11:38
 */
public class Student {
    int height;
    int weight;
    int sex;

    int age;
    int color;
    // 是否佩戴眼镜
    int hasGlasses;

    public Student(StudentBuilder studentBuilder) {
        this.height = studentBuilder.height;
        this.weight = studentBuilder.weight;
        this.sex = studentBuilder.sex;
        this.age = studentBuilder.age;
        this.color = studentBuilder.color;
        this.hasGlasses = studentBuilder.hasGlasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "height=" + height +
                ", weight=" + weight +
                ", sex=" + sex +
                ", age=" + age +
                ", color=" + color +
                ", hasGlasses=" + hasGlasses +
                '}';
    }

    public static class StudentBuilder {
        int height;
        int weight;
        int sex;

        int age;
        int color;
        int hasGlasses;

        public StudentBuilder(int height, int weight, int sex) {
            this.height = height;
            this.weight = weight;
            this.sex = sex;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setColor(int color) {
            this.color = color;
            return this;
        }

        public StudentBuilder setHasGlasses(int hasGlasses) {
            this.hasGlasses = hasGlasses;
            return this;
        }

        public Student builderStudent() {
            return new Student(this);
        }

    }
}
