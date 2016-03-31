package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsRecordVal;

import java.util.List;

public interface ToolsRecordValMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsRecordVal record);

    int insertSelective(ToolsRecordVal record);

    ToolsRecordVal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsRecordVal record);

    int updateByPrimaryKey(ToolsRecordVal record);

    List<ToolsRecordVal> queryTimes();
}