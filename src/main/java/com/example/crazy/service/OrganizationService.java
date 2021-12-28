package com.example.crazy.service;

import com.example.crazy.domain.Organization;
import com.example.crazy.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrganizationService {
    @Resource
    private OrganizationMapper organizationMapper;

    public void edit(Organization organization){
        Organization temp=organizationMapper.selectByPrimaryKey(organization.getOrgName());
        if(temp!=null){
            if(organizationMapper.updateByPrimaryKeyWithBLOBs(organization)!=1){
                throw new RuntimeException("更新失败");
            }
        }else{
            if(organizationMapper.insert(organization)!=1){
                throw new RuntimeException("新增失败");
            }
        }
    }

    public Organization get(String orgName){
        Organization organization=organizationMapper.selectByPrimaryKey(orgName);
        return organization;
    }
}
