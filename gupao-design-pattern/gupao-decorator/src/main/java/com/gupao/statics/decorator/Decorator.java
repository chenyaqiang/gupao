package com.gupao.statics.decorator;

import com.gupao.statics.IBase;

public class Decorator implements IBase {
	IBase base;
	public Decorator(IBase base) {
		this.base = base;
	}

	@Override
	public void baseMethod() {
		// 装饰器可以在这里实现一些自己的内容
		System.out.println("进入装饰器DecoraterImpl自己的方法");
		base.baseMethod();// 调用base自己的方法
	}
}
