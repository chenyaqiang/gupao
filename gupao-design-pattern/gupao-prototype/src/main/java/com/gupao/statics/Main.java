package com.gupao.statics;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.setHead("我有3头");
		robot.setHand("我有6臂");
		robot.setBirthday(new Date());
		Weapon weapon = new Weapon();
		weapon.setAk47("我有茉莉ak47");
		weapon.setM4a1("我有黄金m4a1");
		robot.setWeapon(weapon);

		try {
			Robot cloneRob = (Robot) robot.clone();
			System.out.println("真身地址" + robot + "," + robot.getHead() + "," + robot.getHand() + "," + robot.getBirthday());
			System.out.println("武器地址" + robot.getWeapon() + "," + robot.getWeapon().getAk47() + "," + robot.getWeapon().getM4a1());
			System.out.println("----------------");
			System.out.println("克隆人地址" + cloneRob + "," + cloneRob.getHead() + "," + cloneRob.getHand() + "," + cloneRob.getBirthday());
			System.out.println("武器地址" + cloneRob.getWeapon() + "," + cloneRob.getWeapon().getAk47() + "," + cloneRob.getWeapon().getM4a1());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
