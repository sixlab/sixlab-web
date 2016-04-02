package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsMovie;

import java.util.List;

public interface ToolsMovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsMovie record);

    int insertSelective(ToolsMovie record);

    ToolsMovie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsMovie record);

    int updateByPrimaryKey(ToolsMovie record);

    List<ToolsMovie> queryKeyword(String keyword);
}