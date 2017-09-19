/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller.api.show;

import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.dao.ToolsShowDao;
import cn.sixlab.web.service.HisEventService;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.RespJson;
import cn.sixlab.web.util.Meta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ApiShowController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ApiShowController.class);
    
    @Autowired
    private ToolsShowDao showDao;
    
    @Autowired
    private HisEventService hisService;
    
    @RequestMapping("/search")
    public RespJson search(String keyword) {
        RespJson json = new RespJson();
        
        List<ToolsShow> showList;
        if (StringUtils.isEmpty(keyword)) {
            //ToolsShow show = new ToolsShow();
            //show.setViewStatus(Meta.SHOW_V_STATUS_ING);
            //
            //ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
            //        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
            //        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
            //
            ////创建实例
            //Example<ToolsShow> ex = Example.of(show, matcher);
            showList = showDao.findByViewStatus(Meta.SHOW_V_STATUS_ING);
        } else {
            //ToolsShow show = new ToolsShow();
            //show.setShowName(keyword);
            //show.setTv(keyword);
            //show.setRemark(keyword);
            //
            //ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
            //        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
            //        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
            //        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
            //
            ////创建实例
            //Example<ToolsShow> ex = Example.of(show, matcher);
            
            showList = showDao.findByKeyword(keyword);
        }
        
        int num = 0;
        if (!CollectionUtils.isEmpty(showList)) {
            num = showList.size();
            json.put("shows", showList);
        }
        json.put("num", num);
        
        return json;
    }
    
    @RequestMapping("/watching")
    public RespJson watching(String keyword) {
        RespJson json = new RespJson();
        
        List<ToolsShow> showList;
        if (StringUtils.isEmpty(keyword)) {
            //ToolsShow show = new ToolsShow();
            //show.setViewStatus(Meta.SHOW_V_STATUS_ING);
            //
            //ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
            //        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
            //        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
            //
            ////创建实例
            //Example<ToolsShow> ex = Example.of(show, matcher);
            showList = showDao.findByViewStatus(Meta.SHOW_V_STATUS_ING);
        } else {
            
            showList = showDao.findByStatus(keyword, Meta.SHOW_V_STATUS_ING);
        }
        
        int num = 0;
        if (!CollectionUtils.isEmpty(showList)) {
            num = showList.size();
            json.put("shows", showList);
        }
        json.put("num", num);
        
        return json;
    }
    
    @RequestMapping("/watched")
    public RespJson watched(String keyword) {
        RespJson json = new RespJson();
        
        List<ToolsShow> showList;
        if (StringUtils.isEmpty(keyword)) {
            //ToolsShow show = new ToolsShow();
            //show.setViewStatus(Meta.SHOW_V_STATUS_ING);
            //
            //ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
            //        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
            //        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
            //
            ////创建实例
            //Example<ToolsShow> ex = Example.of(show, matcher);
            showList = showDao.findByViewStatus(Meta.SHOW_V_STATUS_FINISH);
        } else {
            showList = showDao.findByStatus(Meta.SHOW_V_STATUS_FINISH, keyword);
        }
        
        int num = 0;
        if (!CollectionUtils.isEmpty(showList)) {
            num = showList.size();
            json.put("shows", showList);
        }
        json.put("num", num);
        
        return json;
    }
    
    @RequestMapping("/add")
    public RespJson add(ToolsShow toolsShow) {
        RespJson json = new RespJson();
        
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_ING);
        toolsShow.setBeginDate(new Date());
        showDao.save(toolsShow);
        hisService.beginShow(toolsShow);
        
        return json;
    }
    
    @RequestMapping("/season/add")
    public RespJson seasonAdd(int id) {
        RespJson json = new RespJson();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowEpisode(1);
        toolsShow.setShowSeason(toolsShow.getShowSeason() + 1);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        hisService.addSeason(toolsShow);
        
        return json;
    }
    
    @RequestMapping("/episode/add")
    public RespJson episodeAdd(int id) {
        RespJson json = new RespJson();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowEpisode(toolsShow.getShowEpisode() + 1);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        hisService.addEpisode(toolsShow);
        
        return json;
    }
    
    /**
     * 修改观看状态
     *
     * @param id     电视剧的 id
     * @param status 观看的状态
     *               10 将看
     *               20 正看
     *               30 不看
     * @return 处理结果
     * @since 2.2.0
     */
    @RequestMapping("/view/status")
    public RespJson viewStatus(Integer id, String status) {
        RespJson json = new RespJson();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setViewStatus(status);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        
        return json;
    }
    
    /**
     * 不再观看
     *
     * @param id
     * @return
     */
    @RequestMapping("/finish")
    public RespJson finish(int id) {
        RespJson json = new RespJson();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_FINISH);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        
        return json;
    }
}
