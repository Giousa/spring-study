package com.giousa.springstudy.aspect;

public class HelloWorld {

    public void sayHello(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }
}
