package com.bilin.common.utils;

import java.util.Random;

public class CommonUtil {

	public static void main(String[] args){    
		System.out.println(CommonUtil.getRandomInt());
	}

	
	public static int getRandomInt(){
		Random r = new Random();
		int ran1 = r.nextInt(100);
		System.out.println(ran1);
		return ran1;
	}
	
}
