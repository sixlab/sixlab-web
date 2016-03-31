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
 * @since 1.0.0(2016/3/31)
 */
package cn.sixlab.web.mvc;

import cn.sixlab.web.util.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/31)
 */
@Controller
@RequestMapping(value = "/app")
public class AppController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AppController.class);
    
    @Autowired
    private AppService service;
    
    /**
     * 作者：曹林伟
     * 创建时间：2016/3/31 16:45
     * 功能描述：
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String index(ModelMap modelMap) {
        logger.info(">>>>>进入 Controller ");
        
        return "app/index";
    }
}
