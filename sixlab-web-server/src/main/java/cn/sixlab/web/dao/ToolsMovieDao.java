package cn.sixlab.web.dao;

import cn.sixlab.web.bean.ToolsMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by patrick on 2017/6/20.
 */
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
