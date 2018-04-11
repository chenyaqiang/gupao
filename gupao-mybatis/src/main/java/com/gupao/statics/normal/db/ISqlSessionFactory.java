package com.gupao.statics.normal.db;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;

public interface ISqlSessionFactory {
	public SqlSessionFactory getSqlSessionFactory(InputStream inputStream);
}
