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

import cn.sixlab.web.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/1/15)
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);
    private static boolean notInit = true;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if(notInit && null!=request){
            initContext();
            notInit = false;
        }

        if (handler instanceof ResourceHttpRequestHandler ) {
            return true;
        }

        //if (null != request) {
        //    logger.warn("\n\n" + request.getRequestURL().toString() + "\n\n");
        //    Cookie[] cookies = request.getCookies();
        //    if(ArrayUtils.isNotEmpty(cookies)){
        //        Map<String, String> map = new HashMap<>();
        //        for (Cookie cookie : cookies) {
        //            map.put(cookie.getName(), cookie.getValue());
        //        }
        //        request.setAttribute("cookVal", map);
        //    }
        //}


        //
        //DefaultServletHttpRequestHandler
        //if(handler instanceof HandlerMethod){
        //    HandlerMethod handlerMethod = (HandlerMethod) handler;
        //}
        return true;
    }

    private void initContext() {
        WebUtil.putVal("resPath");

        WebUtil.putVal("resVersion", UUID.randomUUID().toString().substring(30));
    }
    //
    //@Override
    //public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    //        ModelAndView modelAndView) throws Exception {
    //    if (handler instanceof ResourceHttpRequestHandler) {
    //
    //    }else{
    //        //if (modelAndView != null) {
    //        //    modelAndView.addObject("resPath", MetaUtil.getValue("resPath"));
    //        //}
    //    }
    //
    //    super.postHandle(request, response, handler, modelAndView);
    //    return;
    //}
    //
    //@Override
    //public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
    //        Object handler, Exception ex) throws Exception {
    //    super.afterCompletion(request, response, handler, ex);
    //}
}
