/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.service;

import cn.sixlab.web.server.beans.ToolsHisEvent;
import cn.sixlab.web.server.beans.ToolsMovie;
import cn.sixlab.web.server.beans.ToolsShow;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author 六楼的雨/Patrick Root
 */
@IocBean
public class HisService {
    private static Logger logger = LoggerFactory.getLogger(HisService.class);
    //历史记录类型
    public static final String HIS_TYPE_SELF = "00";
    public static final String HIS_TYPE_MOVIE = "10";
    public static final String HIS_TYPE_SHOW = "20";
    public static final String HIS_TYPE_POST = "30";
    
    @Inject
    protected Dao dao;
    
    public void sawMovie(ToolsMovie toolsMovie) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(toolsMovie.getId());
        toolsHisEvent.setEvent("观看了电影《" + toolsMovie.getMovieName() + "》");
        toolsHisEvent.setEventDate(toolsMovie.getViewDate());
        dao.insert(toolsHisEvent);
    }
    
    public void beginShow(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》");
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        dao.insert(toolsHisEvent);
    }
    
    public void addSeason(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季");
        
        dao.insert(toolsHisEvent);
    }
    
    public void addEpisode(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("观看了电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季第" + toolsShow.getShowEpisode() + "集");
    
        dao.insert(toolsHisEvent);
    }
    
    public void addPost(String title, Integer postId) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_POST);
        toolsHisEvent.setKeyId(postId);
        toolsHisEvent.setEventDate(new Date());
        toolsHisEvent.setEvent("发布了文章《" + title + "》");
    
        dao.insert(toolsHisEvent);
    }
}
