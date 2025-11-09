package com.wzh.threadstudy.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MovieThread extends Thread {

    static int count = 0;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
//        while (true) {
//            synchronized (MovieThread.class) {
//                if (count < 100) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    count++;
//                    System.out.println(Thread.currentThread().getName() + "-正在播放电影：" + count);
//                } else {
//                    break;
//                }
//            }
//        }

        while (true) {
            lock.lock();
            try {
                if (count < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "-正在播放电影：" + count);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}
