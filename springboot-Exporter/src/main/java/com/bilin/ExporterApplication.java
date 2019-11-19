package com.bilin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

@SpringBootApplication
@EnableScheduling
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
//@MapperScan("com.newcapec.dao.mapper")
public class ExporterApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(ExporterApplication.class, args);
	}
	
	//在服务器启动类中增加如下代码，则打开了JVM监控参数
    /*@Override
    public void run(String... strings) throws Exception {
        DefaultExports.initialize();
    }*/

}