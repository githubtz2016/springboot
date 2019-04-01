package com.ztesoft.rail.log;

import java.util.concurrent.ArrayBlockingQueue;

public class Log4ATaskUtil {

    private static final ArrayBlockingQueue<Log4ATask> queue = new ArrayBlockingQueue<Log4ATask> (5000);

    public static boolean offset(Log4ATask task){
        if(Log4AListener.logListener){
            return queue.offer (task);
        }
        return false;
    }

    public static Log4ATask task(){
        try {
            return queue.take ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return null;
    }

    public static Log4ATask poll(){
        return queue.poll ();
    }

    public static int size(){
        return queue.size ();
    }

}
