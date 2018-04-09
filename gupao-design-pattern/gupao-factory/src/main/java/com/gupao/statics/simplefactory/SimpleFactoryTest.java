package com.gupao.statics.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) throws Exception {
        SimpleFactory sf = new SimpleFactory();
        // section 1
//        System.out.println(sf.getCar("Benz").getName());
//        System.out.println(sf.getCar("Audi").getName());
//        System.out.println(sf.getCar("BMW").getName());

        // section 2

        System.out.println(sf.getCarReflect("com.gupao.statics.Audi").getName());
        System.out.println(sf.getCarReflect("com.gupao.statics.Benz").getName());
        System.out.println(sf.getCarReflect("com.gupao.statics.BMW").getName());
    }
}
