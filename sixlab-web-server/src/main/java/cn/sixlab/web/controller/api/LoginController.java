/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/19 16:29
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller.api;

import cn.sixlab.web.service.UserService;
import cn.sixlab.web.util.RespJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/pub/login", method = RequestMethod.POST)
    public RespJson login(String username, String password) {
        RespJson json = new RespJson();
        
        userService.login(username, password, json);
        
        return json;
    }
}
