package com.bilin.controller.metricsdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import io.prometheus.client.Summary;

@RestController
public class SummaryDemoController {
	private static final Logger logger = LoggerFactory.getLogger(SummaryDemoController.class);
	
    //注册
    static final Summary summaryDemo = Summary.build()
            .quantile(0.5, 0.01)   // 添加50%分位数，允许有5%的误差,相当于求中位数
            .quantile(0.9, 0.01)   // 添加90%分位数，允许有1%的误差
            .name("summaryDemo").labelNames("label1","label2","label3","label4","label5")
            .help("Summary 实例").register();
    //指标埋点
    //@Scheduled(cron="0/5 * * * * ?")
    public void changeSummary(){
    	
        summaryDemo.labels("1","2","3","4","5").observe(1);
        logger.info("changeSummary:{}", summaryDemo.collect());
    }
}
