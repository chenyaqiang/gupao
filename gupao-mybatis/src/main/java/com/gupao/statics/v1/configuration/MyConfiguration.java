package com.gupao.statics.v1.configuration;

import com.gupao.statics.mapper.TipMapper;
import com.gupao.statics.v1.sqlsession.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyConfiguration implements InvocationHandler {
	// sqlSession
	MySqlSession sqlSession;

	public <T> T getMapper(Class<T> clazz, MySqlSession sqlSession) {
		// 关键，为了下边invoke的时候可以返回sqlSession调用selectOne方法
		this.sqlSession = sqlSession;
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, this);
	}
	// jdk代理
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 硬编码实现匹配方法，然后找到相应的sql
		if ((method.getDeclaringClass().getName() + "." + method.getName())
				.equals(TipMapper.class.getName() + ".selectByPrimaryKey")) {
			String sql = TipMapperXml.map.get(TipMapper.class.getName() + ".selectByPrimaryKey");
			return sqlSession.selectOne(sql, args[0]);
		}
		return method.invoke(this, args);
	}
	// 模拟xml解析
	private static class TipMapperXml {
		private final static Map<String, String> map = new HashMap<String, String>();
		static {
			map.put(TipMapper.class.getName() + ".selectByPrimaryKey", "select * from tb_tip where id =%d");
		}
	}
}
