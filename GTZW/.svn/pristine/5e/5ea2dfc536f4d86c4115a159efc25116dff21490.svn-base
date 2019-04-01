package com.ztesoft.rail.thread;

public class taskThread implements Runnable{
    private int timeout;
    private String type;

    public taskThread(int timeout, String type){
        this.timeout = timeout;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeout);
            System.out.println("这是"+type+"线程,延时"+timeout+"ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
