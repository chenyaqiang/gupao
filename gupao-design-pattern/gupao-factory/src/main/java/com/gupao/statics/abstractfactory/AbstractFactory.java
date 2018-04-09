package com.gupao.statics.abstractfactory;

import com.gupao.statics.Car;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {
    public abstract Car getAudi();

    public abstract Car getBenz();
}
