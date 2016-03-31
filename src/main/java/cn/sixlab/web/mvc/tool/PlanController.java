/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.annotation.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@Controller
@RequestMapping("/tool/plan")
public class PlanController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    private PlanService service;

    @RequestMapping(value = {"", "/", "/index"})
    @Login
    public String index(ModelMap model) {
        return "tool/plan/index";
    }

    @RequestMapping("/week")
    @Login
    public String week(ModelMap model) {
        service.index(model);
        return "tool/plan/week";
    }

    @RequestMapping("/month")
    @Login
    public String month(ModelMap model) {
        service.index(model);
        return "tool/plan/month";
    }

    @RequestMapping("/season")
    @Login
    public String season(ModelMap model) {
        service.edit(model);
        return "tool/plan/season";
    }

    @RequestMapping("/year")
    @Login
    public String year(ModelMap model) {
        return "tool/plan/year";
    }

    @RequestMapping("/years")
    @Login
    public String years(ModelMap model) {
        return "tool/plan/years";
    }

}
