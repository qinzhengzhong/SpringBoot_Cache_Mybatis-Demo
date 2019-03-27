package com.allan.snowflake;

/**
 * 获取唯一IDdemo
 */
public class test {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
//			System.out.println(SingletonCreateId.getInstance().createId());
			System.out.println(SingletonCreateId.getIdGenerator().createId());
		}


	}
}
