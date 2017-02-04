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
 * @since 1.0.0(2016/4/2)
>>>>>>> 初始化网站后台项目 sixlab-server
 */
package cn.sixlab.web.server.module.tool;

import cn.sixlab.web.server.beans.ToolsShow;
import cn.sixlab.web.server.service.HisService;
import cn.sixlab.web.server.util.JsonMap;
import cn.sixlab.web.server.util.Meta;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/4/2)
>>>>>>> 初始化网站后台项目 sixlab-server
 */
@IocBean
@At(value = "/tool/show")
public class ShowModule {
    private static Logger logger = LoggerFactory.getLogger(ShowModule.class);
    
    @Inject
    protected Dao dao;
    
    @Inject
    private HisService hisService;
    
    @At(value = {"/", "/index"})
    public String index() {
        
        return "tool/show/index";
    }
    
    @At("/search")
    @Ok("json:compact")
    public JsonMap search(String keyword) {
        JsonMap json = new JsonMap();
    
        List<ToolsShow> showList;
        if (StringUtils.isEmpty(keyword)) {
            Condition cnd = Cnd.where("viewStatus", "=", Meta.SHOW_V_STATUS_ING);
            showList = dao.query(ToolsShow.class,cnd);
        } else {
            if (StringUtils.isNotEmpty(keyword)) {
                keyword = "%" + keyword + "%";
            }
    
            Condition cnd = Cnd.where("show_name", "like", keyword)
                    .or("tv", "like", keyword)
                    .or("remark", "like", keyword);
            showList = dao.query(ToolsShow.class, cnd);
        }
    
        int num = 0;
        if (!CollectionUtils.isEmpty(showList)) {
            num = showList.size();
            json.put("shows", showList);
        }
        json.put("num", num);
        
        return json;
    }
    
    @At("/add")
    @Ok("json:compact")
    public JsonMap add(@Param("..")ToolsShow toolsShow) {
        JsonMap json = new JsonMap();
    
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_ING);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setUpdateDate(new Date());
        dao.insert(toolsShow);
        hisService.beginShow(toolsShow);
        
        return json;
    }
    
    @At("/season/add")
    @Ok("json:compact")
    public JsonMap seasonAdd(int id) {
        JsonMap json = new JsonMap();
    
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(1);
        toolsShow.setShowSeason(toolsShow.getShowSeason() + 1);
        toolsShow.setUpdateDate(new Date());
        dao.update(toolsShow);
        hisService.addSeason(toolsShow);
        
        return json;
    }
    
    @At("/episode/add")
    @Ok("json:compact")
    public JsonMap episodeAdd(int id) {
        JsonMap json = new JsonMap();
    
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(toolsShow.getShowEpisode() + 1);
        toolsShow.setUpdateDate(new Date());
        dao.update(toolsShow);
        hisService.addEpisode(toolsShow);
        
        return json;
    }
    
<<<<<<< HEAD
    /**
     * 修改播放状态
     *
     * @since 2.2.0
     * @param id     电视剧的 id
     * @param status 播放的状态
     *               10 将播
     *               20 正播
     *               30 暂停
     *               40 终止
     * @return 处理结果
     */
    @At("/show/status")
    @Ok("json:compact")
    public JsonMap showStatus(Integer id,String status) {
        JsonMap json = new JsonMap();
        
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setShowStatus(status);
        dao.update(toolsShow);
        
        return json;
    }
    
    /**
     * 修改观看状态
     *
     * @since 2.2.0
     * @param id 电视剧的 id
     * @param status 观看的状态
     *               10 将看
     *               20 正看
     *               30 不看
     * @return 处理结果
     */
    @At("/view/status")
    @Ok("json:compact")
    public JsonMap viewStatus(Integer id, String status) {
        JsonMap json = new JsonMap();
        
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setViewStatus(status);
        dao.update(toolsShow);
        
        return json;
    }
    
    /**
     * 停播
     * @param id
     * @return
     */
=======
>>>>>>> 初始化网站后台项目 sixlab-server
    @At("/end")
    @Ok("json:compact")
    public JsonMap end(int id) {
        JsonMap json = new JsonMap();
    
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_END);
        dao.update(toolsShow);
        
        return json;
    }
    
<<<<<<< HEAD
    /**
     * 不再观看
     * @param id
     * @return
     */
=======
>>>>>>> 初始化网站后台项目 sixlab-server
    @At("/finish")
    @Ok("json:compact")
    public JsonMap finish(int id) {
        JsonMap json = new JsonMap();
    
        ToolsShow toolsShow = dao.fetch(ToolsShow.class, id);
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_FINISH);
        dao.update(toolsShow);
        
        return json;
    }
}
