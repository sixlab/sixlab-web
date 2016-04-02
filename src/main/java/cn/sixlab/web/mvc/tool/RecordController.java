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
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.annotation.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
@Controller
@RequestMapping("/tool/record")
public class RecordController extends BaseController {
    //private static Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private RecordService service;

    @RequestMapping(value = {"", "/", "/index"})
    @Login
    public String index(ModelMap model) {
        return "tool/record/index";
    }

    @RequestMapping("/choose")
    @Login
    public String compare(ModelMap model) {
        service.index(model);
        return "tool/record/choose";
    }

    @Login
    @RequestMapping("/compare/{date1}/{date2}")
    public String compare(@PathVariable Date date1, @PathVariable Date date2,ModelMap model) {
        service.compare(date1, date2, model);
        return "tool/record/compare";
    }

    @RequestMapping("/edit")
    @Login
    public String edit(ModelMap model) {
        service.edit(model);
        return "tool/record/edit";
    }

    @RequestMapping("/add")
    @Login
    @ResponseBody
    public JsonMap add(ModelMap model) {
        JsonMap json = new JsonMap();


        return json;
    }

    @RequestMapping("/del")
    @Login
    @ResponseBody
    public JsonMap del(ModelMap model) {
        JsonMap json = new JsonMap();

        

        return json;
    }

    @RequestMapping("/record")
    @Login
    public String record(ModelMap model) {
        return "tool/record/record";
    }

}
