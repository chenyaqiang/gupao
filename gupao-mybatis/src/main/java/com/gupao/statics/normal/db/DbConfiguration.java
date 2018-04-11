package com.gupao.statics.normal.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbConfiguration {
	private DbConfiguration() {

	}

	/**
	 * 获取local sqlSession对象
	 * @return
	 * @throws IOException
	 */
	public static final SqlSession getSqlSession() throws IOException {
		return DbConfigurationHolder.sqlSession;
	}

	/**
	 * 内部类单例获取数据库连接
	 */
	private abstract static class DbConfigurationHolder {
		private static final SqlSession sqlSession = getSqlSessionHolder(inputStream -> {
			return new SqlSessionFactoryBuilder().build(inputStream, "local");
		});

		private static final SqlSession getSqlSessionHolder(ISqlSessionFactory iSqlSessionFactory) {
			try {
				String resource = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory = iSqlSessionFactory.getSqlSessionFactory(inputStream);
				return sqlSessionFactory.openSession();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}