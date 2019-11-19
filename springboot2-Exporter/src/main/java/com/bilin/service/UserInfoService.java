package com.bilin.service;

import java.util.List;

import com.bilin.entity.UserInfo;

public interface UserInfoService {
    // 写入数据
    void saveData (UserInfo userInfo) ;
    // ID 查询
    UserInfo selectById (Integer id) ;
    // 查询全部
    List<UserInfo> selectList () ;
}
