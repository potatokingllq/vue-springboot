package com.example.crazy.service;

import com.example.crazy.domain.OrgImage;
import com.example.crazy.domain.OrgImageExample;
import com.example.crazy.mapper.OrgImageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrgImageService {
    @Resource
    private OrgImageMapper orgImageMapper;

    static int count=0;

    public List<OrgImage> list(){
        OrgImageExample orgImageExample=new OrgImageExample();
        OrgImageExample.Criteria criteria=orgImageExample.createCriteria();
        criteria.andIdIsNotNull();
        List<OrgImage> orgImageList=orgImageMapper.selectByExampleWithBLOBs(orgImageExample);
        return orgImageList;
    }

    public void add(String image){
        OrgImage orgImage=new OrgImage();
        orgImage.setId(count++);
        orgImage.setImage(image);
        if(orgImageMapper.insert(orgImage)!=1){
            throw new RuntimeException("新增失败");
        }
    }
}
