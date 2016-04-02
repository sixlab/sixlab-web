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
import cn.sixlab.web.mapper.ToolsHisEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/4/2)
 */
@Component
public class HisUtil {

    @Autowired
    private ToolsHisEventMapper toolsHisEventMapper;

    public void sawMovie(ToolsMovie toolsMovie){
        ToolsHisEvent toolsHisEvent = new ToolsHisEvent();
        toolsHisEvent.setEventType(Meta.HIS_TYPE_MOVIE);
        toolsHisEvent.setKeyId(toolsMovie.getId());
        toolsHisEvent.setEvent("观看了电影《" + toolsMovie.getMovieName() + "》。");
        toolsHisEvent.setEventDate(toolsMovie.getViewDate());
        toolsHisEventMapper.insert(toolsHisEvent);
    }
}
