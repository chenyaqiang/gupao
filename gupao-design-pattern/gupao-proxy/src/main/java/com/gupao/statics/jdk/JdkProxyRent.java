package com.gupao.statics.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理租房
 */
public class JdkProxyRent implements InvocationHandler {
	private Rent rent;
	public Object getInstance(Rent rent) throws Exception{
		this.rent = rent;
		Class<?> clazz = rent.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是jdk租房代理：请提供你的找房需求");
		method.invoke(this.rent, args);
		System.out.println("下面我会为你找房");
		return null;
	}
}
