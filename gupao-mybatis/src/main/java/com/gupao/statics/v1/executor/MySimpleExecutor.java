package com.gupao.statics.v1.executor;

import com.gupao.statics.bean.Tip;

import java.sql.*;

public class MySimpleExecutor implements MyExecutor {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/app?characterEncoding=utf-8";
		String username = "root";
		String password = "root";
		try {
			// 加载驱动类
			Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T query(String sql, Object i) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(String.format(sql, i));
			rs = pstm.executeQuery();
			Tip tip = new Tip();
			while (rs.next()) {
				tip.setId(rs.getInt("id"));
				tip.setTipType(rs.getString("tipType"));
				tip.setNumber(rs.getInt("number"));
				tip.setTitle(rs.getString("title"));
				tip.setImageUrl(rs.getString("imageUrl"));
				tip.setContent(rs.getString("content"));
			}
			return (T) tip;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, conn);
		}
		return null;
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {   // 关闭记录集
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {   // 关闭声明
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {  // 关闭连接对象
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
