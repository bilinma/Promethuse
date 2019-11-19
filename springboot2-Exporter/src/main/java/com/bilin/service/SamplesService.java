package com.bilin.service;

import java.util.List;

import com.bilin.entity.Samples;

public interface SamplesService {
    // 写入数据
    void saveData (Samples samples) ;
    // ID 查询
    Samples selectById (String id) ;
    // 查询全部
    List<Samples> selectList () ;
}
