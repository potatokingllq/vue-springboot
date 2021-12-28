package com.example.crazy.controller;

import com.example.crazy.domain.OrgImage;
import com.example.crazy.service.OrgImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/org/image")
public class OrgImageController {
    @Resource
    private OrgImageService orgImageService;

    @PostMapping("/add")
    public String add(@RequestBody String image){
        try{
            orgImageService.add(image);
        }catch (RuntimeException e){
            return e.getMessage();
        }
        return "新增成功";
    }

    @GetMapping("/list")
    public List<OrgImage> list(){
        return orgImageService.list();
    }
}
