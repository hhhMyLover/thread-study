package com.wzh.threadstudy.controller;

import com.wzh.threadstudy.thread.MovieThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieThreadController {

    @RequestMapping("/start")
    public void start() {
        MovieThread movieThread = new MovieThread();
        Thread t1 = new Thread(movieThread, "一号窗口");
        Thread t2 = new Thread(movieThread, "二号窗口");
        Thread t3 = new Thread(movieThread, "三号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}
