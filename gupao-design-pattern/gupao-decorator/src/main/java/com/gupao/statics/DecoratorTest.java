package com.gupao.statics;

import com.gupao.statics.decorator.Decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		IBase defaultBase = new DefaultBase();
		defaultBase = new Decorator(defaultBase);
		defaultBase = new Decorator(defaultBase);
		defaultBase = new Decorator(defaultBase);
		defaultBase.baseMethod();
	}
}
