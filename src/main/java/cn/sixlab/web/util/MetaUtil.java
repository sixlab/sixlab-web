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
 * @since 1.0.0(2016/3/12)
 */
package cn.sixlab.web.util;

import cn.sixlab.web.bean.SixlabMeta;
import cn.sixlab.web.mapper.SixlabMetaMapper;

import java.util.List;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/12)
 */
public class MetaUtil {
    // flag：0-不需登录; 1-需要登录
    public static final String meta_link = "meta_link";

    private static SixlabMetaMapper metaMapper;

    public static List<SixlabMeta> getMetas(SixlabMeta record){
        init();
        return metaMapper.selectByEq(record);
    }

    private static void init() {
        if(null==metaMapper){
            metaMapper = WebUtil.getBean(SixlabMetaMapper.class);
        }
    }

    public static String getValue(String key){
        init();
        SixlabMeta meta = metaMapper.selectByKey(key);
        return meta.getMetaVal();
    }
}
