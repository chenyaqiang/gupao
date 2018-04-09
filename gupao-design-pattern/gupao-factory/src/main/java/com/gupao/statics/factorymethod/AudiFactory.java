package com.gupao.statics.factorymethod;

import com.gupao.statics.Audi;
import com.gupao.statics.Car;

public class AudiFactory extends Audi {
    public Car getAudi(){
        return new Audi();
    }
}
