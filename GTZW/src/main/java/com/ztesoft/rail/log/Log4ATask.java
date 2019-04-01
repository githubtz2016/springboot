package com.ztesoft.rail.log;

public class Log4ATask {

    private FourAccountLogMsg msg;

    public Log4ATask(FourAccountLogMsg msg) {
        this.msg = msg;
    }

    public void run(){
        if(msg != null){
            Log4AUtil.send (msg);
        }
    }

}
