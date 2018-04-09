package com.gupao.statics.v1.executor;

public interface MyExecutor {
	public <T> T query(String sql, Object i);
}
