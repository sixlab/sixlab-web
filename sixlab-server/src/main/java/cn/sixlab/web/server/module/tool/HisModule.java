/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
<<<<<<< HEAD
 * https://sixlab.cn/
=======
 * http://sixlab.cn/
 *
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
package cn.sixlab.web.server.module.tool;

import cn.sixlab.web.server.beans.ToolsHisEvent;
import cn.sixlab.web.server.service.HisService;
import cn.sixlab.web.server.util.JsonMap;
<<<<<<< HEAD
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
=======
import org.nutz.dao.Dao;
>>>>>>> 初始化网站后台项目 sixlab-server
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

/**
 * @author <a href='https://blog.sixlab.cn/'>六楼的雨/Patrick Root</a>
=======
/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
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
<<<<<<< HEAD
    public JsonMap addPost(String title, Integer postId, Date date) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();
        
        hisService.addPost(title, postId, date);
        
        return jsonMap;
    }
    
    @At("/select")
    @Ok("json:compact")
    public JsonMap select(Integer page, Integer size) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();
    
        Pager pager = new Pager(page,size);
    
        Condition cnd = Cnd.orderBy().desc("event_date").desc("id");
    
        List<ToolsHisEvent> eventList = dao.query(ToolsHisEvent.class, cnd, pager);
        int count = dao.count(ToolsHisEvent.class);
        pager.setRecordCount(count);
        
        jsonMap.put("eventList", eventList);
        jsonMap.put("pager",pager);
=======
    public JsonMap addPost(String title, Integer postId) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();
        
        hisService.addPost(title, postId);
        
>>>>>>> 初始化网站后台项目 sixlab-server
        return jsonMap;
    }
}
