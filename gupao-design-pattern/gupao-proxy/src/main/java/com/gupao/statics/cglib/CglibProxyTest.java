package com.gupao.statics.cglib;

import com.gupao.statics.jdk.*;

/**
 * cglib代理测试
 */
public class CglibProxyTest {
	public static void main(String[] args) {
		try {
			// 买票
			Ticker ticker = (Ticker)new CglibHuangniu().getInstance(new Ticker().getClass());
			ticker.buyTicket();
			System.out.println("买票结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
