package com.gupao.statics.v1.sqlsession;

import com.gupao.statics.v1.configuration.MyConfiguration;
import com.gupao.statics.v1.executor.MyExecutor;

public class MySqlSession {
	MyConfiguration configuration;
	MyExecutor executor;

	public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
		this.configuration = configuration;
		this.executor = executor;
	}

	public <T> T selectOne(String sql, Object i) {
		return executor.query(sql, i);
	}

	public <T> T getMapper(Class<T> clazz) {

		return configuration.getMapper(clazz, this);
	}
}
