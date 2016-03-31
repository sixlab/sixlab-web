package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolsRecordItem;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ToolsRecordItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolsRecordItem record);

    int insertSelective(ToolsRecordItem record);

    ToolsRecordItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolsRecordItem record);

    int updateByPrimaryKey(ToolsRecordItem record);

    List<ToolsRecordItem> queryEnableItems();

    List<ToolsRecordItem> queryDelItems();

    List<ToolsRecordItem> queryByTime(@Param("recordDate") Date recordDate);
}