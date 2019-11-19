package com.bilin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.bilin.dao"})
public class Exporter2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exporter2Application.class, args);
	}

}