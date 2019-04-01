package com.ztesoft.rail.log;

import com.ztesoft.rail.utils.XmlUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Log4AUtil {

    /**
     * 日志.
     */
    private final Logger logz = LoggerFactory.getLogger(this.getClass());

    //http://10.109.209.90:21010/gather/services/AioxPort?wsdl
    private static final String REQ_SERVER_ADDRESS = "http://10.109.209.90:21010/gather/services/AioxPort?wsdl";

    public static void send(FourAccountLogMsg logMsg){
        FourAccountLog log = new FourAccountLog ();
        ArrayList<FourAccountLogMsg> logMsgs = new ArrayList<FourAccountLogMsg>();
        logMsgs.add (logMsg);
        log.setMsgList (logMsgs);
        String xml = XmlUtil.object2Xml (log);
        System.out.println ("审计日志请求报文:\n"+xml);
        try {
            String response = getSoapInputStreamPost (xml);
            System.out.println ("审计日志返回报文：\n"+response);
        } catch (Exception e) {
            e.printStackTrace ();
            System.out.println ("审计日志请求失败："+e.getMessage ());
        }

    }

    public static String getSoapInputStreamPost(String soap) throws Exception {
        // WebService服务的地址
        URL url;
        HttpURLConnection conn = null;
        InputStream is = null;
        OutputStream out = null;
        try {
            if (soap != null) {
                url = new URL(REQ_SERVER_ADDRESS);
            System.out.println("------------正在连接服务器--------------");
                conn = (HttpURLConnection) url.openConnection();
            System.out.println("------------连接服务器成功--------------");

                conn.setConnectTimeout (5000);
                // 是否具有输入参数
                conn.setDoInput(true);
                // 是否输出输入参数
                conn.setDoOutput(true);
                // 发POST请求
                conn.setRequestMethod("POST");
                // 设置请求头（注意一定是xml格式）
                conn.setRequestProperty("content-type",
                        "text/xml;charset=utf-8");
                // 获得一个输出流
                out = conn.getOutputStream();

                out.write(soap.getBytes());

                // 获得服务端响应状态码
                int code = conn.getResponseCode();
            System.out.println("------------服务器响应码:"+code+"--------------");
                StringBuffer sb = new StringBuffer();
                if (code == 200) {
                    // 获得一个输入流，读取服务端响应的数据
                    is = conn.getInputStream();
                    byte[] b = new byte[1024];
                    int len = 0;

                    while ((len = is.read(b)) != -1) {
                        String s = new String(b, 0, len, "utf-8");
                        sb.append(s);
                    }
                }
                return sb.toString ();
            }
        }catch (Exception e){
            e.printStackTrace ();
            throw new RuntimeException (e);
        }finally {
            if(is != null){
                is.close ();
            }
            if(out != null){
                out.close ();
            }
        }

        return "";
    }



}

