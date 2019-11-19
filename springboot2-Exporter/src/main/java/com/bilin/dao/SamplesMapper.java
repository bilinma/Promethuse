package com.bilin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bilin.entity.Samples;

public interface SamplesMapper {

    // 写入数据
    void saveData (Samples Samples) ;
    // ID 查询
    Samples selectById (@Param("name") String id) ;
    // 查询全部
    List<Samples> selectList () ;
	
}
