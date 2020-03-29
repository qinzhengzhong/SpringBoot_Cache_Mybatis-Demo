package test;

import com.allan.snowflake.SingletonCreateId;

/**
 * 获取唯一IDdemo
 */
public class CreateIdTest {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
//			System.out.println(SingletonCreateId.getInstance().createId());
			System.out.println(SingletonCreateId.getIdGenerator().createId());
		}


	}
}
