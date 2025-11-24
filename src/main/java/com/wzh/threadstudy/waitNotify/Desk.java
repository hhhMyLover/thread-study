package com.wzh.threadstudy.waitNotify;

public class Desk {
    public static int count = 10;

    public static int flag = 0;

    public static final Object lock = new Object();
}
