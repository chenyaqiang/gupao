package com.gupao.statics;

import com.gupao.statics.feature.IFeature;

public enum Traffic {
	CAR(),
	TRAIN(),
	PLANE();

	private IFeature feature;

	private Traffic(IFeature feature) {
		this.feature = feature;
	}

	public IFeature getFeature() {
		return this.feature;
	}
}
