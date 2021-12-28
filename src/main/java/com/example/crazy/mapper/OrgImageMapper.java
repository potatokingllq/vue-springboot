package com.example.crazy.mapper;

import com.example.crazy.domain.OrgImage;
import com.example.crazy.domain.OrgImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgImageMapper {
    long countByExample(OrgImageExample example);

    int deleteByExample(OrgImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrgImage record);

    int insertSelective(OrgImage record);

    List<OrgImage> selectByExampleWithBLOBs(OrgImageExample example);

    List<OrgImage> selectByExample(OrgImageExample example);

    OrgImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrgImage record, @Param("example") OrgImageExample example);

    int updateByExampleWithBLOBs(@Param("record") OrgImage record, @Param("example") OrgImageExample example);

    int updateByExample(@Param("record") OrgImage record, @Param("example") OrgImageExample example);

    int updateByPrimaryKeySelective(OrgImage record);

    int updateByPrimaryKeyWithBLOBs(OrgImage record);
}