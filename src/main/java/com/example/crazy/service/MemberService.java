package com.example.crazy.service;

import com.example.crazy.domain.Member;
import com.example.crazy.domain.MemberExample;
import com.example.crazy.domain.MemberImage;
import com.example.crazy.mapper.MemberImageMapper;
import com.example.crazy.mapper.MemberMapper;
import com.example.crazy.utils.TokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    /**
     * 注入密码加密实现器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private MemberImageMapper memberImageMapper;

    public List<Member> list(Map<String,String> map) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        if(map.isEmpty()) {
            criteria.andUserNameIsNotNull();
        }else{
            if(map.containsKey("userName")){
                criteria.andUserNameEqualTo(map.get("userName"));
            }else if(map.containsKey("telephone")){
                criteria.andTelephoneEqualTo(Long.parseLong(map.get("telephone")));
            }else if(map.containsKey("name")){
                criteria.andNameEqualTo(map.get("name"));
            }
        }
        List<Member> memberList = memberMapper.selectByExampleWithBLOBs(memberExample);
        return memberList;
    }

    public Member detail(String userName) {
        Member member = memberMapper.selectByPrimaryKey(userName);
        return member;
    }

    public void add(Member member) {
        Member temp = memberMapper.selectByPrimaryKey(member.getUserName());
        if (temp != null) {
            throw new RuntimeException("用户名已被占用");
        }
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andTelephoneEqualTo(member.getTelephone());
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (!members.isEmpty()) {
            throw new RuntimeException("电话号码已被占用");
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        if (memberMapper.insert(member) != 1) {
            throw new RuntimeException("新增失败");
        }
    }

    public void update(Member member) {
        Member temp = memberMapper.selectByPrimaryKey(member.getUserName());
        if (temp == null) {
            throw new RuntimeException("无该条数据");
        }
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        if(member.getTelephone()!=null) {
            criteria.andTelephoneEqualTo(member.getTelephone());
            List<Member> members = memberMapper.selectByExample(memberExample);
            if (!members.isEmpty() && !members.get(0).getUserName().equals(temp.getUserName())) {
                throw new RuntimeException("电话号码已被占用");
            }
        }

        if (memberMapper.updateByPrimaryKeySelective(member) != 1) {
            throw new RuntimeException("更新失败");
        }
    }

    @Transactional
    public void delete(String userName) {
        Member member = memberMapper.selectByPrimaryKey(userName);
        if (member == null) {
            throw new RuntimeException("无该条数据");
        }
        if (memberMapper.deleteByPrimaryKey(userName) != 1) {
            throw new RuntimeException("删除失败");
        }
        MemberImage memberImage = memberImageMapper.selectByPrimaryKey(userName);
        if(memberImage != null) {
            if (memberImageMapper.deleteByPrimaryKey(userName) != 1) {
                throw new RuntimeException("删除失败");
            }
        }
    }

    public Map<String,String> login(Map<String,String> map){
        String token=null;
        Map<String,String> message=new HashMap<>();
        try {
            Member member = memberMapper.selectByPrimaryKey(map.get("userName"));
            if (member == null) {
                throw new RuntimeException("用户不存在");
            } else {
                if (!passwordEncoder.matches(map.get("password"),member.getPassword())) {
                    throw new RuntimeException("密码错误");
                }
                token = TokenUtil.sign(member);
            }
        }catch(RuntimeException e){
            message.put("message",e.getMessage());
            return message;
        }
        message.put("message","登录成功");
        message.put("token",token);
        return message;
    }

    public void resetPass(String userName){
        Member member=memberMapper.selectByPrimaryKey(userName);
        if(member==null){
            throw new RuntimeException("用户不存在");
        }
        Member temp=new Member();
        temp.setUserName(userName);
        temp.setPassword(passwordEncoder.encode("crazyaboutbeer"));
        if(memberMapper.updateByPrimaryKeySelective(temp)!=1){
            throw new RuntimeException("重置密码失败");
        }
    }

    public void updatePass(Map<String,String> map){
        Member member=memberMapper.selectByPrimaryKey(map.get("userName"));
        if(member==null){
            throw new RuntimeException("用户不存在");
        }
        if(!passwordEncoder.matches((map.get("oldPass")),member.getPassword())){
            throw new RuntimeException("旧密码不正确");
        }
        Member temp=new Member();
        temp.setUserName(map.get("userName"));
        temp.setPassword(passwordEncoder.encode(map.get("newPass")));
        if(memberMapper.updateByPrimaryKeySelective(temp)!=1){
            throw new RuntimeException("修改密码失败");
        }
    }
}
