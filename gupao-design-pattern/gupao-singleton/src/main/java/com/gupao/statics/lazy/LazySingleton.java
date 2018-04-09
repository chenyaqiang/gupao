package com.gupao.statics.lazy;

/**
 * 懒汉模式单例
 * 外部需要使用的时候才实例化
 */
public class LazySingleton {
	// 静态块，公共内存区域
	private static LazySingleton instance;

	private LazySingleton() {

	}

	// 调用方法之前，先判断，如果没有初始化，将其进行初始化，并且赋值
	// 增加synchronized关键字可以解决线程安全问题，sync加载静态方法上，是类锁
	public static final LazySingleton getInstance() {
		// 多线程请求时，会有线程安全问题，多个线程在这里的判断都可以是null
		if (instance == null) {
			instance = new LazySingleton();
		}
		// 如果已经初始化，直接返回之前已经保存好的结果
		return instance;
	}

}
