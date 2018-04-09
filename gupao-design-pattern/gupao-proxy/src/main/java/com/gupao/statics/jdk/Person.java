package com.gupao.statics.jdk;

/**
 * 租房客
 */
public class Person implements Rent,Car {
	public void rent() {
		System.out.println("我要租房，三室一厅");
		System.out.println("南北通透，环境优雅");
	}

	public void buyCar() {
		System.out.println("我要买玛莎拉蒂");
		System.out.println("大红色的");
	}
}
