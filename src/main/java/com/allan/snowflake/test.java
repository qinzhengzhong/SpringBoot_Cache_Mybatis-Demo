package com.allan.snowflake;

/**
 * 获取唯一IDdemo
 */
public class test {
	public static void main(String[] args) {
		IdSequenceUtils idSequenceUtils = new IdSequenceUtils();
		System.out.println(idSequenceUtils.createId());
		
		IdGeneratorUtils idGeneratorUtils= new IdGeneratorUtils();
		System.out.println(idGeneratorUtils.createId());
	
		
	}
}
