package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsRecordItem;

public interface ToolsRecordItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsRecordItem record);

    int insertSelective(ToolsRecordItem record);

    ToolsRecordItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsRecordItem record);

    int updateByPrimaryKey(ToolsRecordItem record);
}