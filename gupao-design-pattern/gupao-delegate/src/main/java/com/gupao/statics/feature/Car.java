package com.gupao.statics.feature;

public class Car implements IFeature {
	@Override
	public void speed() {
		System.out.println("我是汽车，速度80km/h");
	}

	@Override
	public void description() {
		System.out.println("汽车虽然速度不快，但是出行方便");
	}
}
