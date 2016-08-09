package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolLinkGroup;

import java.util.List;

public interface ToolLinkGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolLinkGroup record);

    int insertSelective(ToolLinkGroup record);

    ToolLinkGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolLinkGroup record);

    int updateByPrimaryKey(ToolLinkGroup record);
    
    List<ToolLinkGroup> queryKeyword(String keyword);
}