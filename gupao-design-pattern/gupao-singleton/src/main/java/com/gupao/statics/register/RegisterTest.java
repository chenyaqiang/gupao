package com.gupao.statics.register;

public class RegisterTest {
	public static void main(String[] args) {
		RegisterSingleton singleton = RegisterSingleton.getInstance("com.gupao.statics.register.RegisterSingleton");
		System.out.println(singleton);

		System.out.println(RegisterEnum.RED);
	}
}
