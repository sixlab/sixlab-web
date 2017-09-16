/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.service;

import cn.sixlab.web.bean.ToolsHisEvent;
import cn.sixlab.web.bean.ToolsMovie;
import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.dao.ToolsHisEventDao;
import cn.sixlab.web.util.HisType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HisEventService {
    private static Logger logger = LoggerFactory.getLogger(HisEventService.class);
    
    @Autowired
    private ToolsHisEventDao hisEventDao;
    
    /**
     * 观看了电影
     *
     * @param toolsMovie 电视数据
     */
    public void sawMovie(ToolsMovie toolsMovie) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HisType.HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(toolsMovie.getId());
        toolsHisEvent.setEvent("观看了电影《" + toolsMovie.getMovieName() + "》");
        toolsHisEvent.setEventDate(toolsMovie.getViewDate());
        hisEventDao.save(toolsHisEvent);
    }
    
    /**
     * 开始观看新电视剧
     *
     * @param toolsShow 电视剧最新数据
     */
    public void beginShow(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HisType.HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》");
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        hisEventDao.save(toolsHisEvent);
    }
    
    /**
     * 开始观看电视剧新季
     *
     * @param toolsShow 电视剧最新数据
     */
    public void addSeason(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HisType.HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季");
    
        hisEventDao.save(toolsHisEvent);
    }
    
    /**
     * 观看了电视剧新的一集
     *
     * @param toolsShow 电视剧最新数据
     */
    public void addEpisode(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HisType.HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getUpdateDate());
        toolsHisEvent.setEvent("观看了电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季第" + toolsShow.getShowEpisode() + "集");
    
        hisEventDao.save(toolsHisEvent);
    }
    
    /**
     * 发布文章事件
     *
     * @param title  文章标题
     * @param postId 文章 id
     * @param date   发布时间
     */
    public void addPost(String title, Integer postId, Date date) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        
        toolsHisEvent.setEventType(HisType.HIS_TYPE_POST);
        toolsHisEvent.setKeyId(postId);
        toolsHisEvent.setEventDate(date);
        toolsHisEvent.setEvent("发布了文章《" + title + "》");
    
        hisEventDao.save(toolsHisEvent);
    }
    
    /**
     * 再次观看电影事件
     *
     * @param id        电影 id
     * @param movieName 电影名称
     * @param viewDate  观看日期
     */
    public void reViewMovie(Integer id, Integer movieName, Date viewDate) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HisType.HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(id);
        toolsHisEvent.setEvent("重温了电影《" + movieName + "》");
        toolsHisEvent.setEventDate(viewDate);
        hisEventDao.save(toolsHisEvent);
    }
}
