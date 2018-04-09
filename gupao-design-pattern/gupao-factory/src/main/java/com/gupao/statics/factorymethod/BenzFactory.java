package com.gupao.statics.factorymethod;

import com.gupao.statics.Benz;
import com.gupao.statics.Car;

public class BenzFactory extends Benz {
    public Car getBenz() {
        return new Benz();
    }
}
