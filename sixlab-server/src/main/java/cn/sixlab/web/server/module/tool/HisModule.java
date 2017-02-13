/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.module.tool;

import cn.sixlab.web.server.beans.ToolsHisEvent;
import cn.sixlab.web.server.service.HisService;
import cn.sixlab.web.server.util.JsonMap;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 六楼的雨/Patrick Root
 */
@IocBean
@At("/tool/his")
public class HisModule {
    private static Logger logger = LoggerFactory.getLogger(HisModule.class);
    
    @Inject
    protected Dao dao;
    
    @Inject
    protected HisService hisService;
    
    @At(value = {"/", "/index"})
    public String index() {
        logger.info(">>>>>进入 Controller ");
        
        return "tool/his/index";
    }
    
    @At("/addHis")
    @Ok("json:compact")
    public JsonMap addHis(ToolsHisEvent his) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();
    
        dao.insert(his);
        
        return jsonMap;
    }
    
    @At("/addPost")
    @Ok("json:compact")
    public JsonMap addPost(String title, Integer postId) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();
        
        hisService.addPost(title, postId);
        
        return jsonMap;
    }
}
