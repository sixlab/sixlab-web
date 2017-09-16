/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.dao;

import cn.sixlab.web.bean.ToolsMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolsMovieDao extends JpaRepository<ToolsMovie, Integer> {
    
    @Query(
            " select u from ToolsMovie u where" +
            " u.movieName like concat('%',?1,'%') " +
            " OR u.produceYear like concat('%',?1,'%') " +
            " OR u.director like concat('%',?1,'%') " +
            " OR u.remark like concat('%',?1,'%') " +
            " OR u.doubanScore like concat('%',?1,'%') " +
            " OR u.doubanKey like concat('%',?1,'%') " +
            " OR u.doubanInfo like concat('%',?1,'%') "
    )
    List<ToolsMovie> queryByKeyword(@Param("keyword") String keyword);
}
