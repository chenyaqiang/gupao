package com.gupao.statics.simplefactory;

import com.gupao.statics.Audi;
import com.gupao.statics.Benz;
import com.gupao.statics.Car;

/**
 * 简单工厂模式
 */
public class SimpleFactory {
    public Car getCar(String name) throws Exception {
        if ("Audi".equals(name)) {
            return new Audi();
        } else if ("Benz".equals(name)) {
            return new Benz();
        } else {
            throw new Exception("不提供该车型");
        }
    }

    public Car getCarReflect(String name) throws Exception {
        Class clazz = null;
        try {
            clazz = Class.forName(name);
            return (Car) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new Exception("不提供该车型");
    }
}
