package com.ztesoft.rail.log;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FourAccountFactroy {

    public static FourAccountLogMsg createDefault(String clientIp, String moduleId, String moduleName, String opResult, String opType, String opTypeName, String content, String subAccountName) {
        FourAccountLogMsg accountLogMsg = new FourAccountLogMsg ();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        accountLogMsg.setOperateTime (sd.format(new Date()));
        accountLogMsg.setModuleId (moduleId);
        accountLogMsg.setModuleName (moduleName);
        accountLogMsg.setClientAddress (clientIp);
        accountLogMsg.setOperateResult (opResult);
        accountLogMsg.setOpLevelId (FourAccountConstant.OP_LEVEL_1);
        accountLogMsg.setOpTypeId (opType);
        accountLogMsg.setOperateContent (content);
        accountLogMsg.setOpTypeName (opTypeName);
        String address = "127.0.0.1";
        try {
            address = InetAddress.getLocalHost ().getHostAddress ();
        } catch (UnknownHostException e) {
            e.printStackTrace ();
        }
        accountLogMsg.setServerAddress (address);
        accountLogMsg.setSubAccountName (subAccountName);
        return accountLogMsg;
    }


}
