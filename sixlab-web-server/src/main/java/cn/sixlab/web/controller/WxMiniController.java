/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/21
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller;

import cn.sixlab.web.dao.LabMetaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/mini")
public class WxMiniController {
    private static Logger logger = LoggerFactory.getLogger(WxMiniController.class);
    
    @Autowired
    private LabMetaDao metaDao;
    
    @RequestMapping("/push")
    public String push(String echostr) {
    
        metaDao.queryByMetaKey("wxMiniAppId");
        metaDao.queryByMetaKey("wxMiniAppSecret");
        metaDao.queryByMetaKey("wxMiniMyOpenId");
        metaDao.queryByMetaKey("wxMiniToken");
        metaDao.queryByMetaKey("wxMiniAESKey");
        
        return echostr;
    }
}
