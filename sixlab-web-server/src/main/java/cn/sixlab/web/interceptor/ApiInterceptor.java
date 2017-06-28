/*
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.interceptor;

import cn.sixlab.web.bean.SixlabUser;
import cn.sixlab.web.dao.SixlabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by patrick on 2017/6/20.
 */
public class ApiInterceptor implements HandlerInterceptor {
    
    private static String vName = null;
    private static String vToken = null;
    
    @Autowired
    private SixlabUserDao dao;
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(">>> 在请求处理之前进行调用（Controller方法调用之前）");
        String username = httpServletRequest.getParameter("v-name");
        String token = httpServletRequest.getParameter("v-token");
    
        if(vName == null){
            SixlabUser user = dao.findByUsername(username);
            if( null==user){
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json");
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write("{\"success\":false,\"code\":0,\"flag\":\"\",\"message\":\"不存在此用户\"}");
                writer.close();
                return false;
            }else{
                vName = user.getUsername();
                vToken = user.getToken();
            }
        }
    
        if (StringUtils.startsWithIgnoreCase(vName, username)) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("{\"success\":false,\"code\":0,\"flag\":\"\",\"message\":\"用户名不匹配\"}");
            writer.close();
            return false;
        }
    
        if (StringUtils.startsWithIgnoreCase(vToken, token)) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("{\"success\":false,\"code\":0,\"flag\":\"\",\"message\":\"token 不匹配\"}");
            writer.close();
            return false;
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        // System.out.println(">>> 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // System.out.println(">>> 在整个请求结束之后被调用，也就是在DispatcherServlet
        // 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
