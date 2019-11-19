package com.bilin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilin.entity.UserInfo;
import com.bilin.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService ;
    @RequestMapping("/saveData")
    public String saveData (){
        UserInfo userInfo = new UserInfo () ;
        userInfo.setId(4);
        userInfo.setUserName("winter");
        userInfo.setPassWord("567");
        userInfo.setPhone("13977776789");
        userInfo.setEmail("winter");
        userInfo.setCreateDay("2020-02-20");
        userInfoService.saveData(userInfo);
        return "sus";
    }
    @RequestMapping("/selectById")
    public UserInfo selectById () {
        return userInfoService.selectById(1) ;
    }
    @RequestMapping("/selectList")
    public List<UserInfo> selectList () {
        return userInfoService.selectList() ;
    }
}
