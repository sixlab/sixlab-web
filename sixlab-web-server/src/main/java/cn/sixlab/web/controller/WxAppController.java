/*
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.controller;

import cn.sixlab.web.dao.SixlabMetaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patrick on 2017/6/21.
 */
@RestController
@RequestMapping("/wx/app")
public class WxAppController {
    private static Logger logger = LoggerFactory.getLogger(WxAppController.class);
    
    @Autowired
    private SixlabMetaDao metaDao;
    
    @RequestMapping("/push")
    public String push(String echostr) {
    
        metaDao.queryByMetaKey("wxAppId");
        metaDao.queryByMetaKey("wxAppSecret");
        metaDao.queryByMetaKey("wxToken");
        metaDao.queryByMetaKey("wxAESKey");
        metaDao.queryByMetaKey("wxMpId");
        
        
        return echostr;
    }
}