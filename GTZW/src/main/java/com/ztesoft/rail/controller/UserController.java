package com.ztesoft.rail.controller;

import com.ztesoft.rail.domain.User;
import com.ztesoft.rail.log.*;
import com.ztesoft.rail.utils.AppRuntimeException;
import com.ztesoft.rail.utils.IPUtil;
import com.ztesoft.rail.utils.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztesoft.rail.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletResponse response;

    /**
     * 登录验证
     * @param userName,password
     * @return
     */
    @RequestMapping(value = "/getUserByUserName",method = RequestMethod.POST)
    public ResultMsg getUserByUserName(String userName, String password){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = userService.getUserByUserName(userName,password);
        return resultMsg;
    }

    /**
     * 退出登录清理session
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(){
        ServletRequestAttributes servletContainer = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletContainer.getRequest ();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
    }
    /**
     * 4A单点登录.
     * @return
     */
    @RequestMapping("/loginFor4A")
    public void loginFor4A(String appAcctId, String token) {

        String page = "/error-403.html";
        try {
            ServletRequestAttributes servletContainer = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletContainer.getRequest ();

            if (StringUtils.isEmpty(appAcctId)) {
                throw new AppRuntimeException(1, "appAcctId不能为空");
            }

            if (StringUtils.isEmpty(token)) {
                throw new AppRuntimeException(1, "token不能为空");
            }

            String clientIp = IPUtil.getClientIpAddr(request);
            if (clientIp != null && clientIp.indexOf(",") != -1) {
                //取第一个IP
                clientIp = clientIp.split(",", 2)[0];
            }
            //4A校驗直接根据用户id查询系统用户信息
            User user = userService.selectUserBy4AToken(appAcctId, token);

            if (user == null) {
                throw new AppRuntimeException(1, "没有找到对应的系统用户信息");
            }
            final String loginCode = user.getMainAcctId ();
            final String fclientIp = clientIp;
            String content = "4A单点登录: 4A账号："+loginCode+"";

//            FourAccountLogMsg logMsg = FourAccountFactroy.createDefault (fclientIp,
//                    FourAccountConstant.MODULE_ID_PC_LOGIN, FourAccountConstant.MODULE_NAME_PC_LOGIN,
//                    FourAccountConstant.OP_RESULT_SUCCESS, FourAccountConstant.OP_TYPE_PC_LOGIN, FourAccountConstant.OP_NAME_PC_LOGIN,
//                    content, loginCode);
//            Log4ATaskUtil.offset (new Log4ATask(logMsg));

            //所有校驗成功后，設置session
            request.getSession().setAttribute("user",user);

            page = "/index.jsp";
        } catch (AppRuntimeException e) {
            log.error("业务处理异常");
            System.out.println(e.getMsg());
        } catch (Exception ex) {
            log.error("未知登录异常");
            System.out.println(ex.getMessage());
        }
        try{
            response.sendRedirect(page);
        }catch (Exception ex) {
            log.error("重定向页面异常");
            System.out.println(ex.getMessage());
        }

    }


}
