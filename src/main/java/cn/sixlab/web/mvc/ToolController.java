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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@Controller
@RequestMapping("/tool")
public class ToolController extends BaseController {
    //private static Logger logger = LoggerFactory.getLogger(ToolController.class);

    //@Autowired
    //private ToolService service;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(@CookieValue(value = "username", defaultValue = "") String username,
            ModelMap model) {
        model.put("username", username);
        return "tool/index";
    }

    //@Login
    //@RequestMapping(value="/add",method = RequestMethod.GET)
    //public String add() {
    //    return "tool/add";
    //}

    //@Login
    //@RequestMapping(value = "/add", method = RequestMethod.POST)
    //@ResponseBody
    //public JsonMap add(String name, String link, String title, String hasLogin) {
    //    JsonMap jsonMap = new JsonMap();
    //
    //    service.add(name, link,title,hasLogin, jsonMap);
    //
    //    return jsonMap;
    //}
}
