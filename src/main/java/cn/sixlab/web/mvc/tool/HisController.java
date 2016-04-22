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
 * @since 1.0.0
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsHisEvent;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/tool/his")
public class HisController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(HisController.class);

    @Autowired
    private HisService service;
    
    /**
     * 作者：曹林伟
     * 创建时间：2016/4/21 11:21
     * 功能描述：
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String index(ModelMap modelMap) {
        logger.info(">>>>>进入 Controller ");

        return "/tool/his/index";
    }

    /**
     * 作者：曹林伟
     * 创建时间：2016/4/21 11:21
     * 功能描述：
     */
    @RequestMapping(value = {"/addHis"})
    public JsonMap addHis(ToolsHisEvent his) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();

        service.addHis(jsonMap, his);

        return jsonMap;
    }

    /**
     * 作者：曹林伟
     * 创建时间：2016/4/21 11:21
     * 功能描述：
     */
    @RequestMapping(value = {"/addPost"})
    public JsonMap addPost(String title,Integer postId) {
        logger.info(">>>>>进入 Controller ");
        JsonMap jsonMap = new JsonMap();

        service.addPost(jsonMap, title, postId);

        return jsonMap;
    }
}
