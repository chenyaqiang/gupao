package com.gupao.statics;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Date;

/**
 * 机器人
 */
public class Robot implements Serializable, Cloneable {
	private static final long serialVersionUID = 6952764800310175725L;
	private String head;
	private String hand;
	private Weapon weapon;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 直接调用super.clone就是潜克隆
		return deepClone();
	}
	// 深克隆，采用序列化
	public Object deepClone() {
		try {
			// 序列化到文件中
			FileOutputStream fos = new FileOutputStream("d:/robot");
			ObjectOutputStream bos = new ObjectOutputStream(fos);
			bos.writeObject(this);

			// 从文件中读入
			FileInputStream fis = new FileInputStream("d:/robot");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Robot copy = (Robot) ois.readObject();
			copy.setBirthday(new Date());
			return copy;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
