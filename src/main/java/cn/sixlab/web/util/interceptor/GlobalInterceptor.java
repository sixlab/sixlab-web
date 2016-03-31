/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.util.interceptor;

import cn.sixlab.web.util.MetaUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.socket.sockjs.support.SockJsHttpRequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler || handler instanceof SockJsHttpRequestHandler) {
            return true;
        }

        if (null != request) {
            Cookie[] cookies = request.getCookies();
            if(ArrayUtils.isNotEmpty(cookies)){
                Map<String, String> map = new HashMap<>();
                for (Cookie cookie : cookies) {
                    map.put(cookie.getName(), cookie.getValue());
                }

                request.setAttribute("cookVal", map);
            }
            request.setAttribute("resPath", MetaUtil.getValue("resPath"));
        }

        logger.warn("\n\n"+ request.getRequestURL().toString()+"\n\n");

        //DefaultServletHttpRequestHandler
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler || handler instanceof SockJsHttpRequestHandler) {

        }else{
            if (modelAndView != null) {
                modelAndView.addObject("resPath", MetaUtil.getValue("resPath"));
            }
        }

        super.postHandle(request, response, handler, modelAndView);
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
