/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
<<<<<<< HEAD
 * https://sixlab.cn/
 *
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
package cn.sixlab.web.server.module;

=======
 * http://sixlab.cn/
 *
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
 */
package cn.sixlab.web.server.module;

import cn.sixlab.web.server.util.JsonMap;
>>>>>>> 初始化网站后台项目 sixlab-server
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
<<<<<<< HEAD
import org.nutz.mvc.annotation.Ok;
=======
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
>>>>>>> 初始化网站后台项目 sixlab-server
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
@IocBean
public class RootModule {
    private static Logger logger = LoggerFactory.getLogger(RootModule.class);
    
    @Inject
    protected Dao dao;
    
<<<<<<< HEAD
    @At("/tool")
    @Ok("->:/tool.ftl")
    public void tool() {
        
    }
    
=======
>>>>>>> 初始化网站后台项目 sixlab-server
    //@At(value = {"/", "/index"})
    //public String index() {
    //    return "index";
    //}
<<<<<<< HEAD
=======
    
    @At("/login")
    @GET
    public String login() {
        return "login";
    }
    
    @At("/login")
    @POST
    @Ok("json:compact")
    public JsonMap login(String username, String password) {
        JsonMap json = new JsonMap();
        
        //service.login(json, username, password);

        return json;
    }
    
    @At("/logout")
    @Ok("redirect:/index")
    @GET
    public void logout() {
        
        //service.logout();
    }
    
    @At("/change")
    @Ok("json:compact")
    public JsonMap change(String keyword, String value) {
        JsonMap json = new JsonMap();
        
        //service.change(json, keyword, value);
        
        return json;
    }
>>>>>>> 初始化网站后台项目 sixlab-server
}
