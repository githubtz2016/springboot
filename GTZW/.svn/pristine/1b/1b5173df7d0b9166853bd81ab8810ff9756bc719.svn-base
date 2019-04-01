package com.ztesoft.rail.webService.impl;

import com.ztesoft.rail.domain.User;
import com.ztesoft.rail.service.UserService;
import com.ztesoft.rail.xmlEntity.*;
import com.ztesoft.rail.utils.XmlUtil;
import com.ztesoft.rail.webService.FourAccountWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.jws.WebService;


@WebService(targetNamespace = "UpdateAppAcctSoap", endpointInterface = "com.ztesoft.rail.webService.FourAccountWeb", serviceName = "UpdateAppAcctSoap")
public class FourAccountWebImpl implements FourAccountWeb {

    @Autowired
    private UserService userService;

    /**
     * 操作类型变量
     */
    private static final String ADD = "add";
    private static final String CHANGE = "change";
    private static final String DELETE = "delete";
    private static final String CHGSTATUS = "chgstatus";
    private static final String RESETPWD = "resetpwd";

    @Override
    public String updateAppAcctSoap(String xml) {

        System.out.println(xml);
        UserModifyreq userModifyreq = XmlUtil.xml2Object(xml,UserModifyreq.class);
        if(userModifyreq == null){
            System.out.println("userModifyreq is null");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","请求报文格式错误！");
            return XmlUtil.object2Xml(userModifyrsp);
        }
        UserHead userHead = userModifyreq.getUserHead();
        if(userHead == null){
            System.out.println("userHead is null");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","请求报文格式错误！");
            return XmlUtil.object2Xml(userModifyrsp);
        }
        ModifyBody modifyBody = userModifyreq.getModifyBody();
        if(modifyBody == null){
            System.out.println("modifyBody is null");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","请求报文格式错误！");
            return XmlUtil.object2Xml(userModifyrsp);
        }

        String operId = modifyBody.getOperatorId();
        String operPwd = modifyBody.getOperatorPwd();
        if(StringUtils.isEmpty(operId) || StringUtils.isEmpty(operPwd)){
            System.out.println("管理员账号或密码为空");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","管理员账号或密码为空！");
            return XmlUtil.object2Xml(userModifyrsp);
        }
        //根据从账号密码查询鉴权信息
        boolean flag = userService.selelctByAdmin(operId,operPwd);
        if(!flag){
            System.out.println("鉴权失败");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","鉴权失败！");
            return XmlUtil.object2Xml(userModifyrsp);
        }

        String operType = modifyBody.getModifyMode();
        if(StringUtils.isEmpty(operType)){
            System.out.println("操作类型为空");
            UserModifyrsp userModifyrsp = errorResult("SCNGGTZW","key","操作类型为空");
            return XmlUtil.object2Xml(userModifyrsp);
        }
        UserInfo userInfo = modifyBody.getUserinfo();

        //从账号变更操作
        String userId = userInfo.getUserId();
        String loginNo = userInfo.getLoginNo();
        String userName = userInfo.getUserName();
        String orgId = userInfo.getOrgId();
        String email = userInfo.getEmail();
        String mobile = userInfo.getMobile();
        String password = userInfo.getPassword();
        String status = userInfo.getStatus();
        String effdate = userInfo.getEffectDate();
        String expdate = userInfo.getExpireDate();
        String remark = userInfo.getRemark();

        User user = new User();
        try {
            if(ADD.equals(operType)){
                if(StringUtils.isEmpty(loginNo) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(orgId)
                        || StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
                        || StringUtils.isEmpty(effdate) || StringUtils.isEmpty(expdate)){
                    System.out.println("新增从账号有信息为空");
                    UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","新增从账号有信息为空");
                    return XmlUtil.object2Xml(userModifyrsp);
                }else{
                    if(userService.checkLoginNoExist(loginNo)){
                        UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","应用登录名已存在");
                        return XmlUtil.object2Xml(userModifyrsp);
                    }else{
                        user.setUserId(loginNo); //应用登录名和用户标识传一样的
                        user.setMainAcctId(operId);
                        user.setMainPwd(operPwd);
                        user.setLoginNo(loginNo); //应用登录名和用户标识传一样的
                        user.setUserName(userName);
                        user.setOrgId(orgId);
                        user.setEmail(email);
                        user.setMobile(mobile);
                        user.setPassword(password);
                        user.setAPP_ACCT_DESC(remark);
                        user.setEFFECT_DATE(effdate);
                        user.setEXPIRE_DATE(expdate);
                        userService.insert(user);
                    }
                }

            }
            if(CHANGE.equals(operType)){
                if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(loginNo) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(orgId)
                        || StringUtils.isEmpty(mobile) || StringUtils.isEmpty(effdate) || StringUtils.isEmpty(expdate)){
                    System.out.println("修改从账号有信息为空");
                    UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","修改从账号有信息为空");
                    return XmlUtil.object2Xml(userModifyrsp);
                }else{
                    user.setUserId(userId);
                    user.setLoginNo(loginNo);
                    user.setUserName(userName);
                    user.setOrgId(orgId);
                    user.setEmail(email);
                    user.setMobile(mobile);
                    user.setAPP_ACCT_DESC(remark);
                    userService.updateByUserId(user);
                }
            }
            if(DELETE.equals(operType)){
                if(StringUtils.isEmpty(userId)){
                    System.out.println("userId is null");
                    UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","userId is null");
                    return XmlUtil.object2Xml(userModifyrsp);
                }else{
                    userService.deleteByUserId(userId);
                }
            }
            if(CHGSTATUS.equals(operType)){
                if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(status)){
                    System.out.println("userId or status is null");
                    UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","userId or status is null");
                    return XmlUtil.object2Xml(userModifyrsp);
                }else{
                    user.setUserId(userId);
                    user.setAPP_ACCT_STATUS(status);
                    userService.updateByStatus(user);
                }
            }
            if(RESETPWD.equals(operType)){
                if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)){
                    System.out.println("userId or password is null");
                    UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,userId,loginNo,"1","userId or password is null");
                    return XmlUtil.object2Xml(userModifyrsp);
                }else{
                    user.setUserId(userId);
                    user.setPassword(password);
                    userService.updatePasswordByUserId(user);
                }
            }
            System.out.println("success");
            UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,loginNo,loginNo,"0","");
            return XmlUtil.object2Xml(userModifyrsp);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("run is error");
            UserModifyrsp userModifyrsp = successResult("SCNGGTZW",operType,loginNo,loginNo,"1","应用系统运行出错");
            return XmlUtil.object2Xml(userModifyrsp);
        }

    }

    public UserModifyrsp errorResult(String serviceId,String key,String errdesc){
        UserModifyrsp userModifyrsp = new UserModifyrsp();
        UserHead userHead = new UserHead();
        RspBody rspBody = new RspBody();
        userHead.setServiceId(serviceId);
        rspBody.setKey(key);
        rspBody.setErrdesc(errdesc);
        userModifyrsp.setUserHead(userHead);
        userModifyrsp.setRspBody(rspBody);
        return userModifyrsp;
    }

    public UserModifyrsp successResult(String serviceId,String operType,String userId,String loginNo,String rsp,String errdesc){
        UserModifyrsp userModifyrsp = new UserModifyrsp();
        UserHead userHead = new UserHead();
        RspBody rspBody = new RspBody();
        userHead.setServiceId(serviceId);
        rspBody.setModifymode(operType);
        rspBody.setUserId(userId);
        rspBody.setLoginNo(loginNo);
        rspBody.setRsp(rsp);
        rspBody.setErrcode(errdesc);
        userModifyrsp.setUserHead(userHead);
        userModifyrsp.setRspBody(rspBody);
        return userModifyrsp;
    }
}
