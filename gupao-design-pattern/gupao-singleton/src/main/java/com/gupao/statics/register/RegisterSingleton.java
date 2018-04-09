package com.gupao.statics.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例
 * spring中多数使用这种方式实现单例
 */
public class RegisterSingleton {
	private RegisterSingleton() {
	}

	public static Map<String, RegisterSingleton> map = new ConcurrentHashMap<>();

	public static RegisterSingleton getInstance(String className) {
		// 这里要把非containsKey的判断拿到前边来，以防止出现线程安全问题
		if (!map.containsKey(className)) {
			RegisterSingleton singleton = new RegisterSingleton();
			map.put(className, singleton);
			return singleton;
		}
		return map.get(className);
	}
}
