package com.ztesoft.rail.utils;

//import org.apache.http.HttpEntity;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;

import org.springframework.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;

public class HttpClientUtil {

    public static Map<String, String> callByHttp(String url, String parameters) {
        HashMap map = new HashMap();
//        // 创建httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        // 创建post方式请求对象
//        HttpPost httpPost = new HttpPost(url);
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setSocketTimeout(10000).setConnectTimeout(20000)
//                .setConnectionRequestTimeout(10000).build();
//        httpPost.setConfig(requestConfig);
//        StringEntity body = new StringEntity(parameters, "utf-8");
//        httpPost.setEntity(body);
//
//        // 设置回调接口接收的消息头
//        httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
//        CloseableHttpResponse response = null;
//        String result = "";
//        try {
//            response = httpClient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//            result = EntityUtils.toString(entity, HTTP.UTF_8);
//            map.put("resCode", "0");
//            map.put("resMsg", "成功");
//            map.put("result", result);
//            System.out.println("调用WEB：" + result);
//        } catch (Exception e) {
//            map.put("resCode", "-999");
//            map.put("resMsg", e.getMessage());
//            map.put("result", null);
//            System.out.println("调用WEB出错：" + e.getMessage());
//            e.getStackTrace();
//        } finally {
//            try {
//                response.close();
//                httpPost.abort();
//                httpClient.close();
//            } catch (Exception e) {
//                e.getStackTrace();
//            }
//        }
        return map;

    }

    public static void main(String[] args) {
        String url = "http://192.168.8.108:8080/services/UpdateAppAcctSoap?wsdl";
        String methodName = "accountUpdate";
        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n<SSOURLMODIFYREQ>\n<HEAD>\n<SERVICEID>SCNGIPAD</SERVICEID>\n<TIMESTAMP>20180518104500</TIMESTAMP>\n</HEAD>\n<BODY>\n<OPERATORID>lifengguo</OPERATORID>\n<OPERATORIP>10.108.226.56</OPERATORIP>\n<MOBILE>18380478783</MOBILE>\n<SMKEY>642764</SMKEY>\n</BODY>\n</SSOURLMODIFYREQ>\n";
        Object[] parameters = new Object[]{xml};
        Map<String, String> map = callByHttp(url, xml);
        System.out.println(map);
    }


}
