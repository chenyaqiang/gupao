package com.gupao.statics.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * jdk代理测试
 */
public class JdkProxyTest {
	public static void main(String[] args) {
		try {
			// 租房
			Rent rent = (Rent) new JdkProxyRent().getInstance(new Person());
			rent.rent();
			System.out.println("找房结束" + rent.getClass());

			// 买车
			Car car = (Car) new JdkProxyCar().getInstance(new Person());
			car.buyCar();
			System.out.println("买车结束" + car.getClass());

			// 通过反编译工具读到源代码（此处code不受上边code影响，就是生成某一个类的代理类，不会去校验内容的准确性，即便后边的Class[]是一个普通class）
			byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Rent.class});
			FileOutputStream os = new FileOutputStream("d:/$Proxy0.class");
			os.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
