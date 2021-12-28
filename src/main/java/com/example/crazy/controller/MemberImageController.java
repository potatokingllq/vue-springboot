package com.example.crazy.controller;

import com.example.crazy.domain.MemberImage;
import com.example.crazy.service.MemberImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user/image")
public class MemberImageController {

    @Resource
    private MemberImageService memberImageService;

    @PostMapping("/upload")
    public String upload(@RequestBody MemberImage memberImage) {
        try {
            memberImageService.add(memberImage);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "图片写入数据库成功";
    }

    @GetMapping("/get/{userName}")
    public String get(@PathVariable String userName) {
        return memberImageService.get(userName);
    }

    @GetMapping("/list")
    public List<MemberImage> list() {
        return memberImageService.list();
    }
}
