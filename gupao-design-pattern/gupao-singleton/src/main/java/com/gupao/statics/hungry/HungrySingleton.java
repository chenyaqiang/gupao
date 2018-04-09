package com.gupao.statics.hungry;

/**
 * 饿汉模式
 * 优点：没有加任何锁，执行效率比较高，在用户体验上，比懒汉模式更好
 * 缺点：类加载的时候就初始化，不管你用还是不用，都占用空间
 * 线程安全，线程还未访问的时候就实例化成功了，所以每次调用都是请求的已经实例化的
 * 实例化=初始化+赋值
 */
public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {

	}

	public static HungrySingleton getInstance() {
		return instance;
	}
}
