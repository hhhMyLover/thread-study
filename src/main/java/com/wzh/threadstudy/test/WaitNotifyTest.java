package com.wzh.threadstudy.test;

import com.wzh.threadstudy.waitNotify.Cook;
import com.wzh.threadstudy.waitNotify.Food;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Cook());
        Thread t2 = new Thread(new Food());
        t1.start();
        t2.start();
    }
}
