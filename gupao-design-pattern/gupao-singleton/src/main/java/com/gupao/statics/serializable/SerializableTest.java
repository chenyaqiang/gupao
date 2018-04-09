package com.gupao.statics.serializable;

import java.io.*;

public class SerializableTest {
	public static void main(String[] args) {
		SerializableSingleton singleton1 = SerializableSingleton.getInstance();
		System.out.println("singleton1 is " + singleton1);
		try {
			// 通过存储到byteArray中，再反序列化回来，比较是否是同一对象
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(singleton1);

			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			SerializableSingleton singleton2 = (SerializableSingleton) ois.readObject();
			System.out.println("singleton2 is " + singleton2);

			if (ois != null) {
				ois.close();
			}
			if (bis != null) {
				bis.close();
			}
			if (oos != null) {
				oos.close();
			}
			if (bos != null) {
				bos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
