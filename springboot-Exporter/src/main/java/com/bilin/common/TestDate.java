package com.bilin.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class TestDate {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//模拟测试数据
		SimpleDateFormat dateFormat = new SimpleDateFormat("m");
		String valueStr = dateFormat.format(new Date());
		
		System.out.println(valueStr.charAt(1));
		
	}

}
