package com.wzh.threadstudy.thread;

public class ThreadTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    System.out.println("t1 " + i);
                }
            }
        });
        /***
         * 守护线程
         * spring web环境下无法测试，因为内置了很多非守护线程
         * 特点：当其它的非守护线程执行完毕的时候，守护线程也会陆续停止
         * 应用：
         *    -- 聊天应用之中。线程一：聊天；线程二：发送文件。线程二为守护线程  当聊天关闭的时候，文件发送线程就会停止
         */
        t1.setDaemon(true);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2 " + i);
                }
            }
        });

        // 设置线程优先级。优先级范围1-10。默认5。优先级越大，先执行的概率越高
        t2.setPriority(10);

        // 线程休眠
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t1.start();
        t2.start();
    }
}
