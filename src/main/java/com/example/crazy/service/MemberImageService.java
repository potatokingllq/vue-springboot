package com.example.crazy.service;

import com.example.crazy.domain.MemberImage;
import com.example.crazy.domain.MemberImageExample;
import com.example.crazy.mapper.MemberImageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberImageService {

    @Resource
    private MemberImageMapper memberImageMapper;

    public void add(MemberImage memberImage) {
        MemberImage temp = memberImageMapper.selectByPrimaryKey(memberImage.getUserName());
        if (temp != null) {
            if (memberImageMapper.updateByPrimaryKeySelective(memberImage) != 1) {
                throw new RuntimeException("图片写入数据库失败");
            }
        } else {
            if (memberImageMapper.insert(memberImage) != 1) {
                throw new RuntimeException("图片写入数据库失败");
            }
        }
    }

    public String get(String userName){
        MemberImage memberImage=memberImageMapper.selectByPrimaryKey(userName);
        if(memberImage==null){
            return "";
        }
        return memberImage.getImage();
    }

    public List<MemberImage> list(){
        MemberImageExample memberImageExample=new MemberImageExample();
        MemberImageExample.Criteria criteria=memberImageExample.createCriteria();
        criteria.andUserNameIsNotNull();
        List<MemberImage> memberImageList=memberImageMapper.selectByExampleWithBLOBs(memberImageExample);
        return memberImageList;
    }
}
