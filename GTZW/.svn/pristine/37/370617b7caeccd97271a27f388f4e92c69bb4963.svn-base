package com.ztesoft.rail.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ztesoft.rail.utils.Axis2ClientUtil;
import com.ztesoft.rail.utils.CxfClientUtil;
import com.ztesoft.rail.utils.ResultMsg;
import com.ztesoft.rail.xmlEntity.UserRsp;
import com.ztesoft.rail.utils.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.rail.dao.UserDao;
import com.ztesoft.rail.domain.User;
import com.ztesoft.rail.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private UserDao userDao;

    @Override
    public boolean checkLoginNoExist(String loginNo) {
        User user = userDao.getUserByloginNo(loginNo);
        if(user == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean selelctByAdmin(String loginNo,String pwd) {
        boolean flag = false;
        Map map = userDao.selelctByAdmin(loginNo,pwd);
        if(map != null){
            flag = true;
        }
        return flag;
    }

    @Override
    public ResultMsg getUserByUserName(String loginNo,String password) {
        ServletRequestAttributes servletContainer = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletContainer.getRequest ();
        HttpSession session = request.getSession();
        ResultMsg rm = new ResultMsg();
        User user = userDao.getUserByloginNo(loginNo);
        //判断是否存在该用户
        if(user == null){
            rm.setMsg("用户不存在");
            rm.setStatus(0);
        }else{
            if(!user.getPassword().equals(password)){
                rm.setMsg("密码错误");
                rm.setStatus(0);
            }else{
                rm.setData(user);
                rm.setStatus(1);
                session.setAttribute("user",user);
            }
        }
        return rm;
    }

    @Override
    public int deleteByUserId(String userId) {
        return userDao.deleteByUserId(userId);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int updateByUserId(User user) {
        return userDao.updateByUserId(user);
    }

    @Override
    public int updateByStatus(User user) {
        return userDao.updateByStatus(user);
    }

    @Override
    public int updatePasswordByUserId(User user) {
        return userDao.updatePasswordByUserId(user);
    }

    @Override
    public User selectUserBy4AToken(String appAcctId, String token) {
        // 1、MAINACCTID  当前登录主帐号。应用侧获取当前主帐号，应用记录审计日志时需要把当前主帐号发送到4A
        // 2、APPACCTID 当前从帐号登录名.
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = sd.format(new Date());
        String acct = "16|78|48|-8|-48|-122|108|44|-64|22|-49|50|-1|-5|86|-64|89";
        String pwd = "8|6|-96|-76|80|-63|43|-118|66";
        String serviceId = "SCNGGTZW";
        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n"
                + "<USERREQ>\n"
                + "    <AUTH>\n"
                + "        <ACCT>"+acct+"</ACCT>\n"
                + "        <PWD>"+pwd+"</PWD>\n"
                + "    </AUTH>\n"
                + "    <HEAD>\n"
                + "        <CODE></CODE>\n"
                + "        <SID></SID>\n"
                + "        <TIMESTAMP>"+timeStamp+"</TIMESTAMP>\n"
                + "        <SERVICEID>"+serviceId+"</SERVICEID>\n"
                + "    </HEAD>\n"
                + "    <BODY>\n"
                + "        <APPACCTID>"+appAcctId+"</APPACCTID>\n"
                + "        <TOKEN>"+token+"</TOKEN>\n"
                + "    </BODY>\n"
                + "</USERREQ>\n";
        //4a 地址
        //测试地址
        //String url = "http://10.109.209.150:18099/uac/services/CheckAiuapTokenSoap?wsdl&view=true";
        //生产地址
        String url = "http://10.109.209.100:9081/uac/services/CheckAiuapTokenSoap?wsdl&view=true";
        //4a 命名空间
        //String nameSpace = "http://10.109.209.100:9081/uac/services/CheckAiuapTokenSoap";
        //4a 校验方法
        String methodName = "CheckAiuapTokenSoap";
        log.info ("请求xml:"+xml);
        Object[] parameters = new Object[] {xml};
        //Map<String,String> map = Axis2ClientUtil.callByRPC(url, nameSpace, methodName, parameters);
        Map<String,String> map = CxfClientUtil.callByCxf(url,methodName,xml);
        String resCode = map.get("resCode");
        log.info ("返回xml:"+resCode);
        String appacctId = null;
        if("0".equals (resCode)){
            String result = map.get ("result");
            log.info ("返回result:"+result);
            UserRsp userRsp = XmlUtil.xml2Object (result, UserRsp.class);
            if(userRsp != null && userRsp.getUserBody ()!= null){
                String rsp = userRsp.getUserBody ().getRsp ();
                if("0".equals (rsp)){
                    appacctId = userRsp.getUserBody ().getAppacctId ();
                    log.info ("返回主账号:"+userRsp.getUserBody ().getMainacctId ());
                    log.info ("返回appacctId:"+appacctId);
                }
            }
        }
        //根据从账号登录名查询用户信息
        if(appacctId == null || "".equals (appacctId.trim ())){
            return null;
        }
        User user = userDao.selectByUserCode(appacctId);
        if(user != null){
            return user;
        }else{
            return null;
        }

    }


}
