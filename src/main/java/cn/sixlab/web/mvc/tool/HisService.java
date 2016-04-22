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
 * @since 1.0.0
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsHisEvent;
import cn.sixlab.web.mapper.ToolsHisEventMapper;
import cn.sixlab.web.util.HisUtil;
import cn.sixlab.web.util.JsonMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0
 */
@Service
public class HisService {
    private static Logger logger = LoggerFactory.getLogger(HisService.class);

    @Autowired
    private ToolsHisEventMapper toolsHisEventMapper;

    @Autowired
    private HisUtil hisUtil;
    
    public void addHis(JsonMap jsonMap, ToolsHisEvent his) {
        toolsHisEventMapper.insert(his);
    }

    public void addPost(JsonMap jsonMap, String title, Integer postId) {
        hisUtil.addPost(title, postId);
    }
}
