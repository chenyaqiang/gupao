package com.gupao.statics.lazy;

/**
 * 懒汉式内部类单例
 * 特点：内部类只有在外部类被调用的时候，它才会被加载
 * 内部类一定在方法调用之前完成初始化
 * 兼顾了饿汉式的内存浪费，也兼顾了sync的性能问题
 */
public class LazyInnerClass {
	private static boolean initflag = false;

	private LazyInnerClass() {
		// 防止反射入侵，不过依然存在一些弊端
		synchronized (LazyInnerClass.class) {
			if (initflag) {
				throw new RuntimeException("单例已被破坏");
			} else {
				initflag = true;
			}
		}
	}

	// static是为了使单例的空间共享
	// final修饰保证方法不会被重载，被重写
	public static final LazyInnerClass getInstance() {
		return LazyInnerClassHolder.lazy;
	}

	// 静态内部类默认不加载，会在外部类的调用方法（getInstance）之前完成初始化
	private static class LazyInnerClassHolder {
		private static final LazyInnerClass lazy = new LazyInnerClass();
	}

}
