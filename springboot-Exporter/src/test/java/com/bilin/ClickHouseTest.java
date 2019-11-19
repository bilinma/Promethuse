package com.bilin;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.bilin.common.config.ClickHouseConfig;
 
/**
 * @Auther: qixin
 * @Date: 2018/12/11 15:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClickHouseTest {
 
    @Test
    public void getFrsDataTest(){
        System.out.println("******************");
        String sql="select * from metrics.samples t where name='my_gauge_2' limit 1000";
        List<Map> result= ClickHouseConfig.exeSql(sql);
        
        result.stream().forEach(System.out::println);
        System.out.println("******************");
    }
 
}
