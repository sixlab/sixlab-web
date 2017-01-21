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
 * @since 1.0.0(2016/4/2)
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsMovie;
import cn.sixlab.web.mapper.ToolsMovieMapper;
import cn.sixlab.web.util.HisUtil;
import cn.sixlab.web.util.JsonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/4/2)
 */
@Service
@Transactional
public class MovieService {
    //private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private HisUtil hisUtil;

    @Autowired
    private ToolsMovieMapper toolsMovieMapper;

    public void add(JsonMap json, ToolsMovie toolsMovie) {
        toolsMovieMapper.insertSelective(toolsMovie);
        hisUtil.sawMovie(toolsMovie);
    }

    public void search(JsonMap json, String keyword) {
        List<ToolsMovie> movieList = toolsMovieMapper.queryKeyword(keyword);
        int num = 0;
        if (!CollectionUtils.isEmpty(movieList)) {
            num = movieList.size();
            json.put("movies", movieList);
        }
        json.put("num", num);
    }

}
