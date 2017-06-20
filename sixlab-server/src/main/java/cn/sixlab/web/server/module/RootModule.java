/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
package cn.sixlab.web.server.module;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
@IocBean
public class RootModule {
    private static Logger logger = LoggerFactory.getLogger(RootModule.class);
    
    @Inject
    protected Dao dao;
    
    @At("/tool")
    @Ok("->:/tool.ftl")
    public void tool() {
    
    }
    
    //@At(value = {"/", "/index"})
    //public String index() {
    //    return "index";
    //}
}
