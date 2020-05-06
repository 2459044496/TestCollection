package com.cui.thread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/6 18:17
 */
public class CsGameByThreadLocal {
    // 子弹数量
    private static final Integer BULLET_NUMBER = 1500;
    // 杀敌数
    private static final Integer KILLED_ENEMIES = 0;
    // 自己的命数
    private static final Integer LIFE_VALUE = 10;
    // 队员数
    private static final Integer TOTAL_PLAYERS = 10;

    // 随机数展示每个对象的不同的数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL
            = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL
            = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };

    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL
            = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return LIFE_VALUE;
        }
    };

    // 定义每位队员
    private static class Player extends Thread {
        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer lifeValue = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);
            System.out.println(getName() + ", BULLET_NUMBER IS " + bullets);
            System.out.println(getName() + ", KILLED_ENEMIES IS " + killEnemies);
            System.out.println(getName() + ", LIFE_VALUE IS " + lifeValue);

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
