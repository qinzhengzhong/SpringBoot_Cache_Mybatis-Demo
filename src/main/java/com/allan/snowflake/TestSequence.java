package com.allan.snowflake;

/**
 * 
* @ClassName: TestSequence
* @Description: 多线程测试获取唯一序列订单号
* @author qinzz
* @date 2018年8月31日
*
 */
public class TestSequence extends Thread {

	IdGeneratorUtils idGenerator;

	public TestSequence(IdGeneratorUtils idGenerator) {
		this.idGenerator = idGenerator;
	}

	int ct = 0;

	@Override
	public void run() {
		System.out.println();
		while (ct < 100) {
			System.out.println(Thread.currentThread().getId() + " : " + idGenerator.createId());
			ct++;
		}
	}

	public static void main(String[] args) {

		IdGeneratorUtils utils = new IdGeneratorUtils();

		TestSequence test1 = new TestSequence(utils);
		TestSequence test2 = new TestSequence(utils);

		test1.start();
		test2.start();
	}

}
