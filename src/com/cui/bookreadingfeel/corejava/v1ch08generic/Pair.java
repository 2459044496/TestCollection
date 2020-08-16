package com.cui.bookreadingfeel.corejava.v1ch08generic;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/22 14:58
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){}
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
