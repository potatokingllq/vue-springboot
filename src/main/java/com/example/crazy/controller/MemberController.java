package com.example.crazy.controller;

import com.example.crazy.domain.Member;
import com.example.crazy.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping("/list")
    public List<Member> list(@RequestBody Map<String,String> map) {
        return memberService.list(map);
    }

    @GetMapping("/detail/{userName}")
    public Member detail(@PathVariable String userName) {
        return memberService.detail(userName);
    }

    @PostMapping("/add")
    public String add(@RequestBody Member member){
        try{
            memberService.add(member);
        }catch (RuntimeException runtimeException){
            return runtimeException.getMessage();
        }
        return "新增成功";
    }

    @PostMapping("/update")
    public String update(@RequestBody Member member){
        try{
            memberService.update(member);
        }catch (RuntimeException runtimeException){
            return runtimeException.getMessage();
        }
        return "更新成功";
    }

    @GetMapping("/delete/{userName}")
    public String delete(@PathVariable String userName){
        try{
            memberService.delete(userName);
        }catch(RuntimeException runtimeException){
            return runtimeException.getMessage();
        }
        return  "删除成功";
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> map){
        return memberService.login(map);
    }

    @GetMapping("/password/reset/{userName}")
    public String reset(@PathVariable String userName){
        try{
            memberService.resetPass(userName);
        }catch (RuntimeException e){
            return e.getMessage();
        }
        return "重置密码成功";
    }

    @PostMapping("/password/update")
    public String update(@RequestBody Map<String,String> map){
        try{
            memberService.updatePass(map);
        }catch (RuntimeException e){
            return e.getMessage();
        }
        return "修改密码成功";
    }
}
