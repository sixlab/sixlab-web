/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.controller;

import cn.sixlab.web.service.LoginService;
import cn.sixlab.web.util.JsonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonMap login(String username, String password) {
        JsonMap json = new JsonMap();

        service.login(json, username, password);

        return json;
    }
}
