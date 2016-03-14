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
package cn.sixlab.web.service;

import cn.sixlab.web.mapper.SixlabMetaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
@Service
public class ToolService {
    private static Logger logger = LoggerFactory.getLogger(ToolService.class);

    @Autowired
    private SixlabMetaMapper metaMapper;

}
