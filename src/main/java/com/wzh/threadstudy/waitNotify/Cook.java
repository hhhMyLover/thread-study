package com.wzh.threadstudy.waitNotify;

public class Cook implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    System.out.println("厨师：开始做菜");
                    break;
                } else {
                    if (Desk.flag == 0) {
                        Desk.lock.notifyAll();
                        Desk.flag = 1;
                    } else {
                        System.out.println("厨师做好了");
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
