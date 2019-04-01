package com.ztesoft.rail.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器
 */
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        filterChain.doFilter(request, response);

//        //是否需要过滤
//        boolean needFilter = isNeedFilter(uri);
//        boolean notNeedFilter = isNotNeedFilter(uri);
//        if(notNeedFilter){
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else if (!needFilter) { //不需要过滤直接传给下一个过滤器
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else { //需要过滤器
//            // session中包含user对象,则是登录状态
//            if(session!=null&&session.getAttribute("user") != null){
//                filterChain.doFilter(request, response);
//            }else{
//                String requestType = request.getHeader("X-Requested-With");
//                //判断是否是ajax请求
//                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
//                    response.getWriter().write("未登录");
//                }else{
//                    //重定向到登录页(4A的登录页面)
//                    //response.sendRedirect(request.getContextPath()+"/error-403.html");
//                    response.sendRedirect("http://10.109.209.100:9081/uac");
//                }
//            }
//        }
//        return;
    }

    @Override
    public void destroy() {

    }

    /**
     *  是否需要過濾的頁面
     */
    public boolean isNeedFilter(String uri) {
        if(uri.endsWith(".jsp")) {
            return true;
        }
        return false;
    }

    /**
     *  是否需要不過濾的頁面
     */
    public boolean isNotNeedFilter(String uri) {
        if(uri.startsWith("/user/loginFor4A")) {
            return true;
        }
        return false;
    }
}
