package com.gupao.statics.normal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gupao.statics.bean.UserTest;
import com.gupao.statics.mapper.UserTestMapper;
import com.gupao.statics.normal.db.DbConfiguration;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	private static SqlSession sqlSession;

	static {
		try {
			// get sql session
			sqlSession = DbConfiguration.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		/*UserTestMapper userTestMapper = sqlSession.getMapper(UserTestMapper.class);
		UserTest userTest = new UserTest();
		userTest.setName("zhangsan");
		userTest.setSex(1);
		userTest.setAge(23);
		userTest.setBirthday(new Date());
		inserUserTest(userTest);*/
	}

	public static void insertUserTest(UserTest userTest) {
		UserTestMapper userTestMapper = sqlSession.getMapper(UserTestMapper.class);
		int i = userTestMapper.insert(userTest);
		System.out.println("finish insert " + i);
		sqlSession.commit();
	}
	public static void getUserTest(int id) {
		UserTestMapper userTestMapper = sqlSession.getMapper(UserTestMapper.class);
		UserTest userTest = userTestMapper.selectByPrimaryKey(id);
		Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
		System.out.println("userTest is " + gson.toJson(userTest));
	}


}
