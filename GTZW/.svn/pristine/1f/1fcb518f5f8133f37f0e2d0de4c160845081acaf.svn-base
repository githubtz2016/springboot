package com.ztesoft.rail.log;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Log4AListener implements ServletContextListener {

    public static volatile boolean logListener = true;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println ("contextInitialized .......");
        new Thread (new Runnable () {
            @Override
            public void run() {
                while (logListener) {
                    Log4ATask task = Log4ATaskUtil.task ();
                    if(task != null)
                        task.run ();
                }
            }
        }).start ();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println ("contextDestroyed .......");
        logListener = false;
        boolean flag = true;
        System.out.println ("关闭之前剩余总数:"+Log4ATaskUtil.size ());
        while (flag) {
            Log4ATask task = Log4ATaskUtil.poll ();
            if (task == null) {
                flag=false;
                System.out.println ("关闭之前的最后动作");
            }else{
                System.out.println ("关闭之前的执行：...");
                task.run ();
            }
        }
    }
}
