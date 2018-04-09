package com.gupao.statics;

import java.io.Serializable;

/**
 * 武器对象
 */
public class Weapon implements Serializable{
	private static final long serialVersionUID = 6778103962810072067L;
	private String ak47;
	private String m4a1;

	public String getAk47() {
		return ak47;
	}

	public void setAk47(String ak47) {
		this.ak47 = ak47;
	}

	public String getM4a1() {
		return m4a1;
	}

	public void setM4a1(String m4a1) {
		this.m4a1 = m4a1;
	}
}
