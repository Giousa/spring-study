package com.giousa.springstudy.bean;


import java.util.Iterator;
import java.util.ServiceLoader;

public class CustomServiceMain {

    public static void main(String[] args) {
        System.out.println("main start");

        ServiceLoader<CustomServiceCrypt> serviceLoader = ServiceLoader.load(CustomServiceCrypt.class);
        System.out.println(serviceLoader.toString());

        System.out.println("-----------------");

        Iterator<CustomServiceCrypt> iterator = serviceLoader.iterator();
        System.out.println("iterator: " + iterator);
        if (iterator.hasNext()) {
            CustomServiceCrypt customServiceCrypt = iterator.next();
            String str = customServiceCrypt.encrypt("hello world");
            System.out.println("encrypt: " + str);
            String decrypt = customServiceCrypt.decrypt(str);
            System.out.println("decrypt: " + decrypt);
        }
        System.out.println("-----------------");

    }
}
