package com.gupao.statics.serializable;

import java.io.Serializable;

/**
 * 序列化式单例
 * 如果不增加额外处理，反序列化出来的对象和原来对象不同
 */
public class SerializableSingleton implements Serializable {

	private static final long serialVersionUID = -2906522403623856189L;
	// 序列化是把对象在内存中的状态转换成字节码的形式
	// 从而转换成io流，写入到其他地方（可能是磁盘，可能是网络io）
	// 反序列化是将已经持久化的字节码内容转换为io流
	// 通过io流的读取，将读取的内容转换为java对象
	// note:在转换过程中会重新创建对象，但是不会调用任何构造方法
	private final static SerializableSingleton singleton = new SerializableSingleton();

	private SerializableSingleton() {
	}

	public final static SerializableSingleton getInstance() {
		return singleton;
	}

	// 特殊处理，防止反序列化新生成对象
	private Object readResolve() {
		return singleton;
	}
}
