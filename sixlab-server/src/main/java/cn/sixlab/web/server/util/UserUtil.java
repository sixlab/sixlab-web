/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.util;

import cn.sixlab.web.server.beans.SixlabUser;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.Mvcs;

/**
 * @author 六楼的雨/Patrick Root
 */
public class UserUtil {
    
    /**
     * 将用户置为登录
     * @param user
     */
    public static void login(SixlabUser user) {
        String json = Json.toJson(user, JsonFormat.compact());
        //String val = UUID.randomUUID() + "@" + user.getId();
        //Cookie cookie = new Cookie("token",val);
        //cookie.setMaxAge(30*60);
        //Mvcs.getResp().addCookie(cookie);
        Mvcs.getHttpSession().setAttribute("loginToken", json);
    }
    
    /**
     * 判断用户是否登录
     * @return
     */
    public static boolean isLogin() {
        try {
            Object token = Mvcs.getHttpSession().getAttribute("loginToken");
            SixlabUser user = Json.fromJson(SixlabUser.class, token.toString());
            if(null!=user.getUsername()){
                return true;
            }
        }catch (Exception e){
            
        }
        return false;
    }
    
    /**
     * 退出用户
     *
     */
    public static void logout() {
        Mvcs.getHttpSession().removeAttribute("loginToken");
    }
}
