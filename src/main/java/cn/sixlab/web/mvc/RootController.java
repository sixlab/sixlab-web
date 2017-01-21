/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.mvc;

import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.annotation.Finish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/1/15)
 */
@Controller
public class RootController extends BaseController {
    //private static Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private RootService service;

    @RequestMapping(value = {"", "/", "/index"})
    @Finish
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @Finish
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @Finish
    public JsonMap login(String username, String password) {
        JsonMap json = new JsonMap();

        service.login(json, username, password);

        return json;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @Finish
    public String logout() {

        service.logout();

        return "redirect:/index";
    }

    @RequestMapping("/change")
    @ResponseBody
    @Finish
    public JsonMap change(String keyword, String value) {
        JsonMap json = new JsonMap();

        service.change(json, keyword, value);

        return json;
    }
}
