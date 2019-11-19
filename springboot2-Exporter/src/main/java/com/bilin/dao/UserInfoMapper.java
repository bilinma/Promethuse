package com.bilin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bilin.entity.UserInfo;

public interface UserInfoMapper {
    // 写入数据
    void saveData (UserInfo userInfo) ;
    // ID 查询
    UserInfo selectById (@Param("id") Integer id) ;
    // 查询全部
    List<UserInfo> selectList () ;
}