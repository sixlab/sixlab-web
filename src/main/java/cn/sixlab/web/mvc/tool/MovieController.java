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

import cn.sixlab.web.bean.ToolsMovie;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.annotation.Finish;
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
@RequestMapping(value = "/tool/movie")
public class MovieController extends BaseController {
    //private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService service;
    
    /**
     * 作者：曹林伟
     * 创建时间：2016/4/2 19:04
     * 功能描述：
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String index(ModelMap modelMap) {

        return "tool/movie/index";
    }

    @RequestMapping("/add")
    @ResponseBody
    @Finish
    public JsonMap add(ToolsMovie toolsMovie) {
        JsonMap json = new JsonMap();

        service.add(json, toolsMovie);

        return json;
    }

    @RequestMapping("/search")
    @ResponseBody
    @Finish
    public JsonMap search(String keyword) {
        JsonMap json = new JsonMap();

        service.search(json, keyword);

        return json;
    }
}
