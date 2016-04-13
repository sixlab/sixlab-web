/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.util.interceptor;

import cn.sixlab.web.util.UserUtil;
import cn.sixlab.web.util.annotation.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
public class PermissionAnnotationInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler ) {
            return true;
        }
        //DefaultServletHttpRequestHandler
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            loggerParams(request);
            Login login = handlerMethod.getMethodAnnotation(Login.class);
            if (login != null && !UserUtil.isLogin()) {
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }

    private static void loggerParams(HttpServletRequest request) {

        String result = "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>参数\n";
        try {
            String inComeUrl = request.getRequestURL().toString();
            result += inComeUrl;

            Enumeration<String> params = request.getParameterNames();
            String emptyStr = "";
            String paraStr = "";

            while (params.hasMoreElements()) {
                String name = params.nextElement();
                String[] values = request.getParameterValues(name);
                for (String value : values) {
                    if (StringUtils.isEmpty(value)) {
                        emptyStr += "\n\t『" + name + "』";
                    } else {
                        paraStr += "\n\t『" + name + "』=『" + value + "』";
                    }
                }
            }
            result += ("".equals(paraStr) ? "" : ("\n\n参数值：[" + paraStr+"]"));
            result += ("".equals(emptyStr) ? "" : ("\n\nEmpty值为：" + emptyStr));
        } catch (Exception e) {
            result += "输出URL参数错误";
        }

        result += "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";

        logger.warn(result);
    }
}
