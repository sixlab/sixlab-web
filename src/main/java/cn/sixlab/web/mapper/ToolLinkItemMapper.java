package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.ToolLinkItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolLinkItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToolLinkItem record);

    int insertSelective(ToolLinkItem record);

    ToolLinkItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToolLinkItem record);

    int updateByPrimaryKey(ToolLinkItem record);

    List<ToolLinkItem> queryKeyword(@Param("keyword") String keyword, @Param("groupId") int groupId);

    List<ToolLinkItem> queryByGroup(int id);
}