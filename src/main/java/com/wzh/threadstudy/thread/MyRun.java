package com.wzh.threadstudy.thread;

public class MyRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " " + i);
        }
    }
}
