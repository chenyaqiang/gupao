package com.gupao.statics.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * cglib黄牛
 */
public class CglibHuangniu implements MethodInterceptor{
	/**
	 * 生成cglib代理对象
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Object getInstance(Class<?> clazz) throws Exception{
		Enhancer enhancer = new Enhancer();
		// 设置待生成的cglib代理类的父类
		enhancer.setSuperclass(clazz);
		// 利用字节码重组动态创建子类实例
		enhancer.setCallback(new CglibHuangniu());
		return enhancer.create();
	}

	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("我是黄牛，你需要到哪里的车票");
		// 必须要调用super方法
		methodProxy.invokeSuper(o, objects);
		System.out.println("已经给你买到了，你查看一下");
		return null;
	}
}
