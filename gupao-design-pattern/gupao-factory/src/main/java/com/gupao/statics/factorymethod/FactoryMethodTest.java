package com.gupao.statics.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println(new AudiFactory().getAudi().getName());
        System.out.println(new BenzFactory().getBenz().getName());
    }
}
