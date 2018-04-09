package com.gupao.statics.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        System.out.println(new SpecificFactory().getAudi().getName());
        System.out.println(new SpecificFactory().getBenz().getName());
    }
}
