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
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.mapper.ToolsShowMapper;
import cn.sixlab.web.util.HisUtil;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/4/2)
 */
@Service
public class ShowService {
    //private static Logger logger = LoggerFactory.getLogger(ShowService.class);

    @Autowired
    private HisUtil hisUtil;

    @Autowired
    private ToolsShowMapper toolsShowMapper;

    public void search(JsonMap json, String keyword) {
        List<ToolsShow> showList = toolsShowMapper.queryKeyword(keyword);
        int num = 0;
        if (!CollectionUtils.isEmpty(showList)) {
            num = showList.size();
            json.put("shows", showList);
        }
        json.put("num", num);
    }

    public void add(JsonMap json, ToolsShow toolsShow) {
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_ING);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setUpdateDate(new Date());
        toolsShowMapper.insertSelective(toolsShow);
        hisUtil.beginShow(toolsShow);
    }

    public void seasonAdd(JsonMap json, int id) {
        ToolsShow toolsShow = toolsShowMapper.selectByPrimaryKey(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(1);
        toolsShow.setShowSeason(toolsShow.getShowSeason()+1);
        toolsShow.setUpdateDate(new Date());
        toolsShowMapper.updateByPrimaryKey(toolsShow);
        hisUtil.addSeason(toolsShow);
    }

    public void episodeAdd(JsonMap json, int id) {
        ToolsShow toolsShow = toolsShowMapper.selectByPrimaryKey(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(toolsShow.getShowEpisode() + 1);
        toolsShow.setUpdateDate(new Date());
        toolsShowMapper.updateByPrimaryKey(toolsShow);
        hisUtil.addEpisode(toolsShow);
    }

    public void end(JsonMap json, int id) {
        ToolsShow toolsShow = toolsShowMapper.selectByPrimaryKey(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_END);
        toolsShowMapper.updateByPrimaryKey(toolsShow);
    }

    public void finish(JsonMap json, int id) {
        ToolsShow toolsShow = toolsShowMapper.selectByPrimaryKey(id);
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_FINISH);
        toolsShowMapper.updateByPrimaryKey(toolsShow);
    }
}
