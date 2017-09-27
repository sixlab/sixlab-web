/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/27 17:36
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    private static Logger logger = LoggerFactory.getLogger(RootController.class);
    
    @RequestMapping(value = {"/", "/index", "/home"})
    public String index(String echostr) {

        logger.info("访问");
        
        return "index";
    }
}
