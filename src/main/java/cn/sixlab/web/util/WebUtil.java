/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/3/9)
 */
public class WebUtil {

    public static ApplicationContext context;

    private static Object lockContext = new Object();

    public static Cookie[] getCookies() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        return cookies;
    }

    public static String getCookie(String key){
        Cookie[] cookies = getCookies();
        String value = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(key)){
                value = cookie.getValue();
                break;
            }
        }
        return value;
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletContext getContext() {
        return getSession().getServletContext();
    }

    public static String getVal(String key){
        ServletContext servletContext = getContext();
        String value = (String) servletContext.getAttribute(key);
        if (null == value) {
            value = MetaUtil.getValue(key);
            servletContext.setAttribute(key, value);
        }
        return value;
    }

    public static void putVal(String key) {
        ServletContext servletContext = getContext();
        servletContext.setAttribute(key, MetaUtil.getValue(key));
    }

    public static void putVal(String key, String value) {
        ServletContext servletContext = getContext();
        servletContext.setAttribute(key, value);
    }

    public static <T> T getBean(Class<T> clazz) {
        try {
            init();
            return context.getBean(clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void init() {
        if (context == null) {
            synchronized (lockContext) {
                try {
                    context = ContextLoader.getCurrentWebApplicationContext();
                } catch (Exception e) {
                }
            }
        }
    }
}
