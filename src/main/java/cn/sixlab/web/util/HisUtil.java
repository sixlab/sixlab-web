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
 * @since 1.0.0(2016/4/2)
 */
package cn.sixlab.web.util;

import cn.sixlab.web.bean.ToolsHisEvent;
import cn.sixlab.web.bean.ToolsMovie;
import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.mapper.ToolsHisEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/4/2)
 */
@Component
public class HisUtil {
    //历史记录类型
    public static final String HIS_TYPE_SELF = "00";
    public static final String HIS_TYPE_MOVIE = "10";
    public static final String HIS_TYPE_SHOW = "20";
    public static final String HIS_TYPE_POST = "30";

    @Autowired
    private ToolsHisEventMapper toolsHisEventMapper;

    public void sawMovie(ToolsMovie toolsMovie) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(toolsMovie.getId());
        toolsHisEvent.setEvent("观看了电影《" + toolsMovie.getMovieName() + "》");
        toolsHisEvent.setEventDate(toolsMovie.getViewDate());
        toolsHisEventMapper.insert(toolsHisEvent);
    }

    public void beginShow(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》");
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        toolsHisEventMapper.insert(toolsHisEvent);
    }

    public void addSeason(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();

        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        toolsHisEvent.setEvent("开始观看电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季");

        toolsHisEventMapper.insert(toolsHisEvent);
    }

    public void addEpisode(ToolsShow toolsShow) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();

        toolsHisEvent.setEventType(HIS_TYPE_SHOW);
        toolsHisEvent.setKeyId(toolsShow.getId());
        toolsHisEvent.setEventDate(toolsShow.getBeginDate());
        toolsHisEvent.setEvent("观看了电视剧《" + toolsShow.getShowName() + "》第"
                + toolsShow.getShowSeason() + "季第" + toolsShow.getShowEpisode() + "集");

        toolsHisEventMapper.insert(toolsHisEvent);
    }

    public void addPost(String title, Integer postId) {
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();

        toolsHisEvent.setEventType(HIS_TYPE_POST);
        toolsHisEvent.setKeyId(postId);
        toolsHisEvent.setEventDate(new Date());
        toolsHisEvent.setEvent("发布了文章《" + title + "》");

        toolsHisEventMapper.insert(toolsHisEvent);
    }
}
