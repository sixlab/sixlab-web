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
package cn.sixlab.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
public class UserUtil {

    public static boolean isLogin() {
        boolean hasLogin = false;
        Cookie[] cookies = WebUtil.getCookies();
        for (Cookie cookie : cookies) {
            if("username".equals(cookie.getName())){
                hasLogin = true;
                setLogin(cookie.getValue());
            }
        }
        return hasLogin;
    }

    public static void setLogin(String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");

        HttpServletResponse response = WebUtil.getResponse();
        response.addCookie(cookie);
    }

    public static void setLogout() {
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");

        HttpServletResponse response = WebUtil.getResponse();
        response.addCookie(cookie);
    }
}
