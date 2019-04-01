package com.ztesoft.rail.utils;

import java.io.Serializable;

/**
 * 封装一个统一的json返回类型
 */
public class ResultMsg implements Serializable {
        private Object data;
        private String msg;
        private int status;
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
}
