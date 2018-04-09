package com.gupao.statics.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理买车
 */
public class JdkProxyCar implements InvocationHandler {
	private Car car;
	public Object getInstance(Car car) throws Exception{
		this.car = car;
		Class<?> clazz = car.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是jdk买车经理：请提供你的买车需求");
		method.invoke(this.car, args);
		System.out.println("下面我会为你买车");
		return null;
	}
}
