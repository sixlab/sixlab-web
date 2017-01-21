/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolLinkGroup;
import cn.sixlab.web.bean.ToolLinkItem;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/tool/link")
public class LinkController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(LinkController.class);
    
    @Autowired
    private LinkService service;
    
    /**
     * 作者：曹林伟
     * 创建时间：2016/5/26 4:02
     * 功能描述：
     */
    @RequestMapping(value = {"", "/", "/index"})
    public String index(ModelMap modelMap) {
        logger.info(">>>>>进入 Controller ");
        
        return "tool/link/index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonMap add(ToolLinkItem toolLinkItem) {
        JsonMap json = new JsonMap();

        service.addItem(toolLinkItem);

        return json;
    }

    @RequestMapping("/del")
    @ResponseBody
    public JsonMap del(int id) {
        JsonMap json = new JsonMap();

        service.delItem(id);

        return json;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonMap update(ToolLinkItem toolLinkItem) {
        JsonMap json = new JsonMap();

        service.updateItem(toolLinkItem);

        return json;
    }

    @RequestMapping("/search")
    @ResponseBody
    public JsonMap search(String keyword,int id) {
        JsonMap json = new JsonMap();

        service.searchItem(json, keyword, id);

        return json;
    }

    @RequestMapping("/group/add")
    @ResponseBody
    public JsonMap addGroup(ToolLinkGroup toolLinkGroup) {
        JsonMap json = new JsonMap();

        service.addGroup(toolLinkGroup);

        return json;
    }

    @RequestMapping("/group/del")
    @ResponseBody
    public JsonMap delGroup(int id) {
        JsonMap json = new JsonMap();

        service.delGroup(id);

        return json;
    }

    @RequestMapping("/group/update")
    @ResponseBody
    public JsonMap updateGroup(ToolLinkGroup toolLinkGroup) {
        JsonMap json = new JsonMap();

        service.updateGroup(toolLinkGroup);

        return json;
    }

    @RequestMapping("/group/search")
    @ResponseBody
    public JsonMap searchGroup(String keyword) {
        JsonMap json = new JsonMap();

        service.searchGroup(json, keyword);

        return json;
    }

    @RequestMapping("/group")
    @ResponseBody
    public JsonMap group(int id) {
        JsonMap json = new JsonMap();

        service.group(json, id);

        return json;
    }
}
