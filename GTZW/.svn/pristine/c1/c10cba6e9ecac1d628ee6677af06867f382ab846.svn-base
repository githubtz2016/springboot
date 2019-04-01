package com.ztesoft.rail.schedulerTask;

import com.ztesoft.rail.thread.taskThread;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTest {
    private int count=0;

    //@Scheduled(cron="0 30 10 ? * *")
    private void process(){
        Thread t1 = new Thread(new taskThread(5000,"D"));
        Thread t2 = new Thread(new taskThread(4000,"C"));
        Thread t3 = new Thread(new taskThread(1000,"A"));
        Thread t4 = new Thread(new taskThread(2000,"B"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
