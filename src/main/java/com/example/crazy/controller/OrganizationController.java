package com.example.crazy.controller;

import com.example.crazy.domain.Organization;
import com.example.crazy.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;

    @PostMapping("/edit")
    public String edit(@RequestBody Organization organization){
        try{
            organizationService.edit(organization);
        }catch(RuntimeException e){
            return e.getMessage();
        }
        return "更新成功";
    }

    @GetMapping("/get/{orgName}")
    public Organization get(@PathVariable String orgName){
        return organizationService.get(orgName);
    }
}
