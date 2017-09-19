/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.interceptor;

import cn.sixlab.web.util.RespJson;
import cn.sixlab.web.util.JsonUtl;
import cn.sixlab.web.util.UserCache;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ApiInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(">>> 在请求处理之前进行调用（Controller方法调用之前）");
        
        String accessToken = httpServletRequest.getHeader("accessToken");
        
        
        RespJson model = new RespJson();
        if (accessToken == null) {
            model.setErrorMessage("没有 Token", 10000);
        }
        
        if (null == UserCache.get(accessToken)) {
            model.setErrorMessage("登录失效", 10001);
        }
        
        if (!model.isSuccess()) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(JsonUtl.toJSon(model));
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
