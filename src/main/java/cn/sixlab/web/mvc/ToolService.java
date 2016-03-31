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
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.mvc;

import cn.sixlab.web.bean.SixlabMeta;
import cn.sixlab.web.mapper.SixlabMetaMapper;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.MetaUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
@Service
public class ToolService {
    private static Logger logger = LoggerFactory.getLogger(ToolService.class);

    @Autowired
    private SixlabMetaMapper metaMapper;

    public void add(String name, String link, String title, String hasLogin, JsonMap jsonMap) {
        if(StringUtils.isEmpty(hasLogin)){
            hasLogin = "0";
        }

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("href", link);
        map.put("title", title);
        map.put("target", "_blank");
        String json = JSON.toJSONString(map);

        SixlabMeta meta = new SixlabMeta();
        meta.setMetaKey(MetaUtil.meta_link);
        meta.setMetaFlag(hasLogin);
        meta.setMetaRemark(json);
        metaMapper.insert(meta);
        jsonMap.setSuccess(true);
    }
}
