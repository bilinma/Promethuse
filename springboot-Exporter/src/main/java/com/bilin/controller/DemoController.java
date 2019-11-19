package com.bilin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilin.common.annotation.PrometheusMetrics;
import com.bilin.common.config.ClickHouseConfig;

@RestController
public class DemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	/**
	 * 监控本服务接口访问demo
	 * @return
	 */
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	@ResponseBody
	@PrometheusMetrics
	public String hello() {
		logger.info("调用：hello,返回：{}", "Hello World");
	    return "Hello World";
	}

	@GetMapping(value = "/select")
    public void select() {
        String sql = "select * from metrics.samples t where name='my_gauge_2' limit 1000";
        List<Map> result = ClickHouseConfig.exeSql(sql);
        result.stream().forEach(System.out::println);
    }
	
	
}
