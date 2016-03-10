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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("/back")
    public String back(HttpServletRequest request) {
        System.out.println("\n\n\n\n"+request.getServletPath()+"\n\n\n\n");
        return "test";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Map json() {
        Map a = new HashMap<>();
        a.put("abc1", 123);
        a.put("abc2", 123);
        return a;
    }
}
