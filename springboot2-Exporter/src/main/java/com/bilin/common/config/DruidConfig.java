package com.bilin.common.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig {
    @Resource
    private JdbcParamConfig jdbcParamConfig ;
    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(jdbcParamConfig.getUrl());
        datasource.setDriverClassName(jdbcParamConfig.getDriverClassName());
        datasource.setInitialSize(jdbcParamConfig.getInitialSize());
        datasource.setMinIdle(jdbcParamConfig.getMinIdle());
        datasource.setMaxActive(jdbcParamConfig.getMaxActive());
        datasource.setMaxWait(jdbcParamConfig.getMaxWait());
        return datasource;
    }
}
