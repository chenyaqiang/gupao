package com.gupao.statics.v1;

import com.google.gson.Gson;
import com.gupao.statics.bean.Tip;
import com.gupao.statics.v1.configuration.MyConfiguration;
import com.gupao.statics.v1.executor.MySimpleExecutor;
import com.gupao.statics.mapper.TipMapper;
import com.gupao.statics.v1.sqlsession.MySqlSession;

public class Main {
	public static void main(String[] args) {
		MySqlSession sqlSession = new MySqlSession(new MyConfiguration(), new MySimpleExecutor());
		TipMapper tipMapper = sqlSession.getMapper(TipMapper.class);
		Tip tip = tipMapper.selectByPrimaryKey(1);
		System.out.println(new Gson().toJson(tip));
	}
}
