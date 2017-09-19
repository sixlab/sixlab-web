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
package cn.sixlab.web.controller.api.movie;

import cn.sixlab.web.bean.ToolsMovie;
import cn.sixlab.web.dao.ToolsMovieDao;
import cn.sixlab.web.service.HisEventService;
import cn.sixlab.web.util.BaseController;
import cn.sixlab.web.util.RespJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class ApiMovieController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ApiMovieController.class);
    
    @Autowired
    private ToolsMovieDao movieDao;
    
    @Autowired
    private HisEventService hisService;
    
    @RequestMapping("/add")
    public RespJson add(ToolsMovie toolsMovie) {
        RespJson json = new RespJson();
        
        movieDao.save(toolsMovie);
        hisService.sawMovie(toolsMovie);
        
        return json;
    }
    
    @RequestMapping("/modify")
    public RespJson modify(ToolsMovie toolsMovie) {
        RespJson json = new RespJson();
        
        movieDao.save(toolsMovie);
        
        return json;
    }
    
    @RequestMapping("/review")
    public RespJson review(Integer id, Integer movieName, Date viewDate) {
        RespJson json = new RespJson();
        
        hisService.reViewMovie(id, movieName, viewDate);
        
        return json;
    }
    
    @RequestMapping("/search")
    public RespJson search(String keyword) {
        RespJson json = new RespJson();
    
    
        //ToolsMovie movie = new ToolsMovie();
        //movie.setMovieName(keyword);
        //movie.setProduceYear(keyword);
        //movie.setDirector(keyword);
        //movie.setRemark(keyword);
        //movie.setDoubanKey(keyword);
        //movie.setDoubanInfo(keyword);
        //
        ////创建匹配器，即如何使用查询条件
        //ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
        //        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
        //        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
        //        //.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
        //        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        //
        //Example<ToolsMovie> ex = Example.of(movie, matcher);
        
        //List<ToolsMovie> movieList = movieDao.findAll(ex);
        List<ToolsMovie> movieList = movieDao.queryByKeyword(keyword);
        
        int num = 0;
        if (!CollectionUtils.isEmpty(movieList)) {
            num = movieList.size();
            json.put("movies", movieList);
        }
        json.put("num", num);
        
        return json;
    }
}
