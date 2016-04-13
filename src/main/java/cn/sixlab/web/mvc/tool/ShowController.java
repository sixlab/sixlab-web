/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/4/2)
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.annotation.Finish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/4/2)
 */
@Controller
@RequestMapping(value = "/tool/show")
public class ShowController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ShowController.class);
    
    @Autowired
    private ShowService service;
    
    /**
     * 作者：曹林伟
     * 创建时间：2016/4/2 20:20
     * 功能描述：
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String index(ModelMap modelMap) {
        
        return "tool/show/index";
    }

    @RequestMapping("/search")
    @ResponseBody
    @Finish
    public JsonMap search(String keyword) {
        JsonMap json = new JsonMap();
        logger.error("\n\n\n参数:" + keyword + "\n\n\n");

        service.search(json, keyword);

        return json;
    }

    @RequestMapping("/season/add")
    @ResponseBody
    @Finish
    public JsonMap seasonAdd(int id) {
        JsonMap json = new JsonMap();

        service.seasonAdd(json, id);

        return json;
    }

    @RequestMapping("/episode/add")
    @ResponseBody
    @Finish
    public JsonMap episodeAdd(int id) {
        JsonMap json = new JsonMap();

        service.episodeAdd(json, id);

        return json;
    }

    @RequestMapping("/end")
    @ResponseBody
    @Finish
    public JsonMap end(int id) {
        JsonMap json = new JsonMap();

        service.end(json, id);

        return json;
    }

    @RequestMapping("/finish")
    @ResponseBody
    @Finish
    public JsonMap finish(int id) {
        JsonMap json = new JsonMap();

        service.finish(json, id);

        return json;
    }

    @RequestMapping("/add")
    @ResponseBody
    @Finish
    public JsonMap add(ToolsShow toolsShow) {
        JsonMap json = new JsonMap();

        service.add(json, toolsShow);

        return json;
    }
}
