package cn.sixlab.web.mapper;

import cn.sixlab.web.bean.SixlabMeta;

import java.util.List;

public interface SixlabMetaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SixlabMeta record);

    int insertSelective(SixlabMeta record);

    SixlabMeta selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SixlabMeta record);

    int updateByPrimaryKey(SixlabMeta record);

    List<SixlabMeta> selectByEq(SixlabMeta record);
}