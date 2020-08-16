package com.cui.bookreadingfeel.corejava.v1ch08generic;

import javax.swing.*;
import java.awt.*;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/22 15:07
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] word = { "cui", "pai", "is", "a", "boy"};
        Pair<String> mm = ArrayAlg.minmax(word);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
        System.out.println(getMiddel("a","b","c","d","e"));
    }

    public static <T> T getMiddel(T... args) {
        return args[args.length / 2];
    }
}
