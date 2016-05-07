package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolsShowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsShow record);

    int insertSelective(ToolsShow record);

    ToolsShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsShow record);

    int updateByPrimaryKey(ToolsShow record);

    List<ToolsShow> queryKeyword(@Param("keyword") String keyword);

    List<ToolsShow> queryIng();
}