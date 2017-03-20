/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
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
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
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
    
    /**
     * 观看了电影
     *
     * @param toolsMovie 电视数据
     */
    public void sawMovie(ToolsMovie toolsMovie) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(toolsMovie.getId());
        toolsHisEvent.setEvent("观看了电影《" + toolsMovie.getMovieName() + "》");
        toolsHisEvent.setEventDate(toolsMovie.getViewDate());
        dao.insert(toolsHisEvent);
    }
    
    /**
     * 开始观看新电视剧
     *
     * @param toolsShow 电视剧最新数据
     */
    public void beginShow(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》");
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        dao.insert(toolsHisEvent);
    }
    
    /**
     * 开始观看电视剧新季
     *
     * @param toolsShow 电视剧最新数据
     */
    public void addSeason(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季");
        
        dao.insert(toolsHisEvent);
    }
    
    /**
     * 观看了电视剧新的一集
     *
     * @param toolsShow 电视剧最新数据
     */
    public void addEpisode(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("观看了电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季第" + toolsShow.getShowEpisode() + "集");
    
        dao.insert(toolsHisEvent);
    }
    
    /**
     * 发布文章事件
     *
     * @param title 文章标题
     * @param postId 文章 id
     * @param date 发布时间
     */
    public void addPost(String title, Integer postId, Date date) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HIS_TYPE_POST);
        toolsHisEvent.setKeyId(postId);
        toolsHisEvent.setEventDate(date);
        toolsHisEvent.setEvent("发布了文章《" + title + "》");
    
        dao.insert(toolsHisEvent);
    }
    
    /**
     * 再次观看电影事件
     *
     * @param id 电影 id
     * @param movieName 电影名称
     * @param viewDate 观看日期
     */
    public void reViewMovie(Integer id, Integer movieName, Date viewDate) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(id);
        toolsHisEvent.setEvent("重温了电影《" + movieName + "》");
        toolsHisEvent.setEventDate(viewDate);
        dao.insert(toolsHisEvent);
    }
}
