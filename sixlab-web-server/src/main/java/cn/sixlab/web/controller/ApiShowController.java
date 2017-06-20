package cn.sixlab.web.controller;

import cn.sixlab.web.bean.ToolsShow;
import cn.sixlab.web.dao.ToolsShowDao;
import cn.sixlab.web.service.HisEventService;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.JsonModel;
import cn.sixlab.web.util.Meta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by patrick on 2017/6/20.
 */
@RestController
@RequestMapping("/api/show")
public class ApiShowController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(ApiShowController.class);
    
    @Autowired
    private ToolsShowDao showDao;
    
    @Autowired
    private HisEventService hisService;
    
    @RequestMapping("/search")
    public JsonModel search(String keyword) {
        JsonModel json = new JsonModel();
        
        List<ToolsShow> showList;
        if (StringUtils.isEmpty(keyword)) {
            ToolsShow show = new ToolsShow();
            show.setViewStatus(Meta.SHOW_V_STATUS_ING);
            
            ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                    .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
                    .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
    
            //创建实例
            Example<ToolsShow> ex = Example.of(show, matcher);
            showList = showDao.findAll(ex);
        } else {
            ToolsShow show = new ToolsShow();
            show.setShowName(keyword);
            show.setTv(keyword);
            show.setRemark(keyword);
    
            ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                    .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
                    .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
    
            //创建实例
            Example<ToolsShow> ex = Example.of(show, matcher);
            showList = showDao.findAll(ex);
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
    public JsonModel add(ToolsShow toolsShow) {
        JsonModel json = new JsonModel();
        
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_ING);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        hisService.beginShow(toolsShow);
        
        return json;
    }
    
    @RequestMapping("/season/add")
    public JsonModel seasonAdd(int id) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(1);
        toolsShow.setShowSeason(toolsShow.getShowSeason() + 1);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        hisService.addSeason(toolsShow);
        
        return json;
    }
    
    @RequestMapping("/episode/add")
    public JsonModel episodeAdd(int id) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_ING);
        toolsShow.setShowEpisode(toolsShow.getShowEpisode() + 1);
        toolsShow.setUpdateDate(new Date());
        showDao.save(toolsShow);
        hisService.addEpisode(toolsShow);
        
        return json;
    }
    
    /**
     * 修改播放状态
     *
     * @param id     电视剧的 id
     * @param status 播放的状态
     *               10 将播
     *               20 正播
     *               30 暂停
     *               40 终止
     * @return 处理结果
     * @since 2.2.0
     */
    @RequestMapping("/show/status")
    public JsonModel showStatus(Integer id, String status) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowStatus(status);
        showDao.save(toolsShow);
        
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
    public JsonModel viewStatus(Integer id, String status) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setViewStatus(status);
        showDao.save(toolsShow);
        
        return json;
    }
    
    /**
     * 停播
     *
     * @param id
     * @return
     */
    @RequestMapping("/end")
    public JsonModel end(int id) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setShowStatus(Meta.SHOW_STATUS_END);
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
    public JsonModel finish(int id) {
        JsonModel json = new JsonModel();
        
        ToolsShow toolsShow = showDao.findOne(id);
        toolsShow.setViewStatus(Meta.SHOW_V_STATUS_FINISH);
        showDao.save(toolsShow);
        
        return json;
    }
}
