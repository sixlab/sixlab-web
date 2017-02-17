/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.module.tool;

import cn.sixlab.web.server.beans.ToolsMovie;
import cn.sixlab.web.server.service.HisService;
import cn.sixlab.web.server.util.JsonMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 六楼的雨/Patrick Root
 */
@IocBean
@At("/tool/movie")
public class MovieModule {
    private static Logger logger = LoggerFactory.getLogger(MovieModule.class);
    
    @Inject
    protected Dao dao;
    
    @Inject
    private HisService hisService;
    
    @Ok("->:/tool/movie/index")
    @At(value = {"/", "/index"})
    public String index() {
        
        return "tool/movie/index";
    }
    
    @At("/add")
    @Ok("json:compact")
    @POST
    public JsonMap add(@Param("..")ToolsMovie toolsMovie) {
        JsonMap json = new JsonMap();
        
        dao.insert(toolsMovie);
        
        hisService.sawMovie(toolsMovie);
        
        return json;
    }
    
    @At("/search")
    @Ok("json:compact")
    public JsonMap search(String keyword) {
        JsonMap json = new JsonMap();
        
        if (StringUtils.isNoneEmpty(keyword)) {
            keyword = "%" + keyword + "%";
        }
        
        Condition cnd = Cnd.where("movieName", "like", keyword)
                .or("produceYear", "like", keyword)
                .or("director", "like", keyword)
                .or("remark", "like", keyword)
                .or("doubanKey", "like", keyword)
                .or("doubanInfo", "like", keyword);
        
        List<ToolsMovie> movieList = dao.query(ToolsMovie.class, cnd);
        int num = 0;
        if (!CollectionUtils.isEmpty(movieList)) {
            num = movieList.size();
            json.put("movies", movieList);
        }
        json.put("num", num);
        
        return json;
    }
}
