package com.example.crazy.mapper;

import com.example.crazy.domain.Organization;
import com.example.crazy.domain.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(String orgName);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExampleWithBLOBs(OrganizationExample example);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(String orgName);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExampleWithBLOBs(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKeyWithBLOBs(Organization record);

    int updateByPrimaryKey(Organization record);
}