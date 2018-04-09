package com.gupao.statics.lazy;

import com.gupao.statics.lazy.LazyInnerClass;
import com.gupao.statics.lazy.LazySingleton;

import java.lang.reflect.Constructor;

public class ReflectTest {
	public static void main(String[] args) {
		try {
			// 获得private和public类型的构造器
			Constructor con = LazySingleton.class.getDeclaredConstructor(null);
			con.setAccessible(true);
			LazySingleton singleton1 = (LazySingleton) con.newInstance();
			System.out.println("singleton1 is" + singleton1);
			LazySingleton singleton2 = (LazySingleton) con.newInstance();
			System.out.println("singleton2 is" + singleton2);

			Constructor conInner = LazyInnerClass.class.getDeclaredConstructor(null);
			conInner.setAccessible(true);
			LazyInnerClass inner1 = (LazyInnerClass) conInner.newInstance();
			System.out.println("inner1 is" + inner1);
			LazyInnerClass inner2 = (LazyInnerClass) conInner.newInstance();
			System.out.println("inner2 is" + inner2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
