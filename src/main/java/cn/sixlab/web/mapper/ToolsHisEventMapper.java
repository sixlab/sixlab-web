package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsHisEvent;

public interface ToolsHisEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsHisEvent record);

    int insertSelective(ToolsHisEvent record);

    ToolsHisEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsHisEvent record);

    int updateByPrimaryKey(ToolsHisEvent record);
}