package com.gupao.statics.abstractfactory;

import com.gupao.statics.Audi;
import com.gupao.statics.Benz;
import com.gupao.statics.Car;

/**
 * 具体工厂
 */
public class SpecificFactory extends AbstractFactory {
    public Car getAudi() {
        return new Audi();
    }

    public Car getBenz() {
        return new Benz();
    }
}
