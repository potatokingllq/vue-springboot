package com.example.crazy.mapper;

import com.example.crazy.domain.MemberImage;
import com.example.crazy.domain.MemberImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberImageMapper {
    long countByExample(MemberImageExample example);

    int deleteByExample(MemberImageExample example);

    int deleteByPrimaryKey(String userName);

    int insert(MemberImage record);

    int insertSelective(MemberImage record);

    List<MemberImage> selectByExampleWithBLOBs(MemberImageExample example);

    List<MemberImage> selectByExample(MemberImageExample example);

    MemberImage selectByPrimaryKey(String userName);

    int updateByExampleSelective(@Param("record") MemberImage record, @Param("example") MemberImageExample example);

    int updateByExampleWithBLOBs(@Param("record") MemberImage record, @Param("example") MemberImageExample example);

    int updateByExample(@Param("record") MemberImage record, @Param("example") MemberImageExample example);

    int updateByPrimaryKeySelective(MemberImage record);

    int updateByPrimaryKeyWithBLOBs(MemberImage record);
}