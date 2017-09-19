/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/19 16:46
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller.api;

import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.RespJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRootController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ApiRootController.class);
    
    @RequestMapping("/checkLogin")
    public RespJson checkLogin() {
        RespJson json = new RespJson();
        json.setMessage("已登录");
        return json;
    }
    
}
