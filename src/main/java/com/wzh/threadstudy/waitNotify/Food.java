package com.wzh.threadstudy.waitNotify;

public class Food implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    System.out.println("生产：没菜了");
                    break;
                } else {
                    if (Desk.flag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Desk.count--;
                        System.out.println("总共有" + Desk.count + "，吃了" + (10 - Desk.count));
                        Desk.lock.notifyAll();
                        Desk.flag = 0;
                    }
                }
            }
        }
    }
}
