package com.giousa.springstudy.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class SpringBeanTest {

    public static void main(String[] args) {

        UserBean userBean= new UserBean(1L,"giousa",100);

        userBean.sleep();

        Class clazz = userBean.getClass();
        System.out.println("clazz : "+clazz);

        try {

            Method[] methods = clazz.getMethods();
            System.out.println("methods = "+methods);
            Arrays.stream(methods).forEach(it -> {
                System.out.println("Method : "+it);
                System.out.println("Method Modifiers : "+ Modifier.toString(it.getModifiers()));
                System.out.println("Method ParameterTypes : "+it.getParameterTypes());
                Arrays.stream(it.getParameterTypes()).forEach(item -> System.out.println("Method ParameterType : "+item.getName()));
            });
            Field[] fields = clazz.getFields();
            Arrays.stream(fields).forEach(it -> {
                System.out.println("Field : "+it);
                System.out.println("Field Modifiers : "+Modifier.toString(it.getModifiers()));
            });
            Constructor[] constructors = clazz.getConstructors();
            Arrays.stream(constructors).forEach(it -> {
                System.out.println("Constructor : "+it);
                System.out.println("Constructor Modifiers : "+Modifier.toString(it.getModifiers()));
                System.out.println("Constructor ParameterTypes : "+it.getParameterTypes());
                Arrays.stream(it.getParameterTypes()).forEach(item -> System.out.println("Constructor ParameterType : "+item.getName()));
            });

            System.out.println("------------------");

            Method eatMethod = clazz.getDeclaredMethod("eat");
            System.out.println("method eat: "+eatMethod);
            eatMethod.setAccessible(true);
            eatMethod.invoke(userBean);

            System.out.println("name1: "+userBean.getName());
            userBean.setName("hello world");
            System.out.println("name2: "+userBean.getName());

            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(userBean,"reflect name Giousa");
            System.out.println("name3: "+userBean.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
