package com.ztesoft.rail.utils;

import com.ztesoft.rail.webService.CommonService;
import com.ztesoft.rail.webService.CommonTokenService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.HashMap;
import java.util.Map;

public class CxfClientUtil {

    public static Map<String, String> callByCxf(String url, String methodName, String parameters) {
        HashMap map = new HashMap();

        try {
            // 创建动态客户端
//            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//            Client client = dcf.createClient(url);
//            Object[] result = new Object[0];
//            // invoke("方法名",参数1,参数2,参数3....);
//            result = client.invoke(methodName, parameters);
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(CommonTokenService.class);
            factory.setAddress(url);
            // 创建接口代理对象
            CommonTokenService service = (CommonTokenService) factory.create();
            String result = service.checkAiuapTokenSoap(parameters);
            System.out.println(result);
            map.put("resCode", "0");
            map.put("resMsg", "成功");
            map.put("result", result);
            System.out.println("调用WEB：" + result);
        } catch (Exception e) {
            map.put("resCode", "-999");
            map.put("resMsg", e.getMessage());
            map.put("result", (Object)null);
            System.out.println("调用WEB出错：" + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
//        String url = "http://localhost:8080/services/CheckAiuapTokenSoap?wsdl";
//        String methodName = "accountUpdate";
//        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n"
//                + "<USERREQ>\n"
//                + "    <AUTH>\n"
//                + "        <ACCT>"+1+"</ACCT>\n"
//                + "        <PWD>"+1+"</PWD>\n"
//                + "    </AUTH>\n"
//                + "    <HEAD>\n"
//                + "        <CODE></CODE>\n"
//                + "        <SID></SID>\n"
//                + "        <TIMESTAMP>"+1+"</TIMESTAMP>\n"
//                + "        <SERVICEID>"+1+"</SERVICEID>\n"
//                + "    </HEAD>\n"
//                + "    <BODY>\n"
//                + "        <APPACCTID>"+1+"</APPACCTID>\n"
//                + "        <TOKEN>"+1+"</TOKEN>\n"
//                + "    </BODY>\n"
//                + "</USERREQ>\n";
//        Object[] parameters = new Object[]{xml};
//        Map<String, String> map = callByCxf(url, methodName, xml);
//        System.out.println(map);
        String url = "http://192.168.8.130:8090/ecmServer?wsdl";
        String parameters = "         \t\t<ROOT>\n" +
                "\t<HEADER>\n" +
                "\t\t<TRANSACTION_ID>123123123</TRANSACTION_ID>\n" +
                "\t\t<SERVICE_CODE>memberCheck</SERVICE_CODE>\n" +
                "\t\t<CLIENT_NAME>SCCRM0</CLIENT_NAME>\n" +
                "\t\t<PASSWORD>12345</PASSWORD>\n" +
                "\t</HEADER>\n" +
                "\t<BODY>\n" +
                "\t\t<CUST_CODE>131313</CUST_CODE>\n" +
                "\t\t<PHONE_NO>131313</PHONE_NO>\n" +
                "\t</BODY>\n" +
                "</ROOT>";
        String methodName = "commonService";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(CommonService.class);
        factory.setAddress(url);
        // 创建接口代理对象
        CommonService service = (CommonService) factory.create();
        String result = service.commonService(parameters);
        System.out.println(result);

    }


}
