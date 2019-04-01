package com.ztesoft.rail.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * IP 工具类
 */
public class IPUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 阿里云ip查询URL地址.
     */
    public static final String IP_INFO_TAOBAO_URL = "http://ip.taobao.com/service/getIpInfo.php?ip=";

    /**
     * ip地址为内外地址时返回的信息字符串.
     */
    public static final String LOCAL_IP_INFO_NAME = "未分配或者内网IP";

    /**
     * 看指定的ip是在pattern设置的范围内.
     * pattern举例
     * 127.0.0.1;10.1.*.*;10.2.3.0-10.2.3.255
     *
     * @param ip
     * @param patterns
     * @return
     * @author zhouwenqing 2017-05-05
     */
    public static boolean ipv4PatternMatch(String ip, String patterns) {
        if (ip == null) {
            return false;
        }
        if (patterns == null) {
            return true;
        }

        int[] ipInts = ipv4ToInts(ip);


        String[] aPattern = patterns.split(";|,");
        for (String pattern : aPattern) {
            if (ipv4SinglePatternMatch(ipInts, pattern)) {
                return true;
            }
        }
        return false;
    }

    /**
     * IPV4转化为4个整形的数值
     * @author zhouwenqing 2017-05-05
     * @param ip
     * @return
     */
    public static int[] ipv4ToInts(String ip){
        String[] ipFields = ip.split("\\.");
        if(ipFields.length!=4){
            throw new RuntimeException("ip地址格式不正确,ip="+ip);
        }
        int[] ipInts = new int[4];
        for(int i=0;i<ipInts.length;i++){
            ipInts[i] = Integer.parseInt( ipFields[i] );
        }
        return ipInts;
    }

    /**
     * IPV4转化为long类型
     * @author zhouwenqing 2017-05-05
     * @param ipInts
     * @return
     */
    public static long ipv4ToLong(int[] ipInts){
        long ipLongValue;
        ipLongValue = (ipInts[0]<<24) & 0x0FFFFFFFF;
        ipLongValue =  ipLongValue + (ipInts[1]<<16);
        ipLongValue =  ipLongValue + (ipInts[2]<<8);
        ipLongValue += ipInts[3];
        return ipLongValue;
    }

    private static boolean ipv4SinglePatternMatch(int[] ipInts, String pattern){

        if(pattern.indexOf("-")!=-1){
            String[] aTmp = pattern.split("-");
            String minIp = aTmp[0];
            String maxIp = aTmp[1];
            int[] minIpInts = ipv4ToInts(minIp);
            int[] maxIpInts = ipv4ToInts(maxIp);
            long ipLongValue = ipv4ToLong(ipInts);
            long minIpLongValue = ipv4ToLong(minIpInts);
            long maxIpLongValue = ipv4ToLong(maxIpInts);
            if(ipLongValue<minIpLongValue || ipLongValue>maxIpLongValue){
                return false;
            }
        }else{
            String[] ipFields = pattern.split("\\.");
            if(ipFields.length!=4){
                return false;
            }
            for(int i=0;i<ipFields.length;i++){
                String fieldValue = ipFields[i];
                if("*".equals(fieldValue)){
                    continue;
                }
                if(ipInts[i]!=Integer.parseInt(fieldValue)){
                    return false;
                }
            }
        }
        return true;
    }


    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        try {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
                    InetAddress addr = InetAddress.getLocalHost();
                    ip = addr.getHostAddress().toString();
                }
            }
            if (ip != null) {
                if (ip.indexOf(",") != -1) {
                    ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
                }
            }

        }
        catch (Exception e) {
            System.out.println("未知异常，程序继续运行。");
        }
        return ip;
    }

    public static String getLocalIP() {
        String sIP = "";
        InetAddress ip = null;
        try {
            // 如果是Windows操作系统
            if (isWindowsOS()) {
                ip = InetAddress.getLocalHost();
            }
            else {
                boolean bFindIP = false;
                Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
                while (netInterfaces.hasMoreElements()) {
                    if (bFindIP) {
                        break;
                    }
                    NetworkInterface ni = netInterfaces.nextElement();

                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        ip = ips.nextElement();
                        if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                                && ip.getHostAddress().indexOf(":") == -1) {
                            bFindIP = true;
                            break;
                        }
                    }

                }
            }
            if (null != ip) {
                sIP = ip.getHostAddress();
            }
            return sIP;
        }
        catch (Exception e) {
            System.out.println("获取IP异常，程序继续运行。");
            return "127.0.0.1";
        }
    }

    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
}

