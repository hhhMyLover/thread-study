package com.wzh.threadstudy.controller;

import com.wzh.threadstudy.thread.MyCall;
import com.wzh.threadstudy.thread.MyRun;
import com.wzh.threadstudy.thread.MyThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.FutureTask;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    /**
     * 创建多线程 （继承thread类）
     * @return
     */
    @GetMapping("/baseThread")
    public String baseThread() {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        return "success";
    }

    /**
     * 创建多线程 （实现runnable接口）
     * @return
     */
    @GetMapping("/runnable")
    public String runnable() {
        MyRun r1 = new MyRun();
        MyRun r2 = new MyRun();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        return "success";
    }

    /**
     * 创建多线程 （实现callable接口）
     */
    @GetMapping("/callable")
    public String callable() {
        MyCall call = new MyCall();
        FutureTask<Integer> task = new FutureTask<>(call);
        Thread t1 = new Thread(task);
        t1.setName("t1");
        t1.start();
        try {
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
