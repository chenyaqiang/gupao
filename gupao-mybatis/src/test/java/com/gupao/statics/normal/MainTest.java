package com.gupao.statics.normal;

import com.gupao.statics.bean.UserTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MainTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertUserTest() {
		UserTest userTest = new UserTest();
		userTest.setName("lisi");
		userTest.setSex(2);
		userTest.setAge(25);
		userTest.setBirthday(new Date());
		Main.insertUserTest(userTest);
	}

	@Test
	public void getUserTest() {
		Main.getUserTest(4);
	}
}