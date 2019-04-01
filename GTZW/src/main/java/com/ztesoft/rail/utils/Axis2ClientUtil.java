package com.ztesoft.rail.utils;

//import org.apache.axiom.om.OMElement;
//import org.apache.axis2.addressing.EndpointReference;
//import org.apache.axis2.client.Options;
//import org.apache.axis2.rpc.client.RPCServiceClient;
//
//import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class Axis2ClientUtil {

    public Axis2ClientUtil() {
    }

    public static Map<String, String> callByRPC(String url, String nameSpace, String methodName, Object[] parameters) {
        HashMap map = new HashMap();

//        try {
//            RPCServiceClient serviceClient = new RPCServiceClient();
//            EndpointReference targetEPR = new EndpointReference(url);
//            Options options = serviceClient.getOptions();
//            options.setTo(targetEPR);
//            options.setAction("urn:" + methodName);
//            QName qname = new QName(nameSpace, methodName);
//            OMElement element = serviceClient.invokeBlocking(qname, parameters);
//            String result = element.getFirstElement().getText();
//            map.put("resCode", "0");
//            map.put("resMsg", "成功");
//            map.put("result", result);
//            System.out.println("调用WEB：" + result);
//        } catch (Exception var11) {
//            map.put("resCode", "-999");
//            map.put("resMsg", var11.getMessage());
//            map.put("result", (Object)null);
//            System.out.println("调用WEB出错：" + var11.getMessage());
//            var11.printStackTrace();
//        }

        return map;
    }

    public static void main(String[] args) {
        String url = "http://10.109.209.100:9081/uac/services/SmAuthenCheckServices?wsdl&view=true";
        String nameSpace = "http://10.109.209.100:9081/uac/services/SmAuthenCheckServices";
        String methodName = "SmAuthenCheckServices";
        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n<SSOURLMODIFYREQ>\n<HEAD>\n<SERVICEID>SCNGIPAD</SERVICEID>\n<TIMESTAMP>20180518104500</TIMESTAMP>\n</HEAD>\n<BODY>\n<OPERATORID>lifengguo</OPERATORID>\n<OPERATORIP>10.108.226.56</OPERATORIP>\n<MOBILE>18380478783</MOBILE>\n<SMKEY>642764</SMKEY>\n</BODY>\n</SSOURLMODIFYREQ>\n";
        Object[] parameters = new Object[]{xml};
        Map<String, String> map = callByRPC(url, nameSpace, methodName, parameters);
        System.out.println(map);
    }
}
