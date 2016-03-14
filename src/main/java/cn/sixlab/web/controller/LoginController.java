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
import cn.sixlab.web.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        HttpServletResponse response = WebUtil.getResponse();
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
