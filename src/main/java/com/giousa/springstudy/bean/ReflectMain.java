package com.giousa.springstudy.bean;

import java.lang.reflect.Method;

public class ReflectMain {

    public static void main(String[] args) {
        try {

            UserBean userBean = (UserBean) Class.forName("com.giousa.springstudy.bean.UserBean").newInstance();
            System.out.println("userBean: " + userBean);

            userBean.setId(1L);
            userBean.setName("不笑猫");
            userBean.setAge(19);

            System.out.println("userBean2: " + userBean);

            Method eat = userBean.getClass().getDeclaredMethod("eat");
            eat.setAccessible(true);
            eat.invoke(userBean);


            Method sayMethod = userBean.getClass().getDeclaredMethod("say", java.lang.String.class);
            sayMethod.setAccessible(true);
            String resultSay = (String) sayMethod.invoke(userBean, "today is a good day");
            System.out.println(">>>>>>>: " + resultSay);

            Method leftMethod = userBean.getClass().getDeclaredMethod("left", String.class, Integer.class);
            leftMethod.setAccessible(true);
            String resultLeft = (String) leftMethod.invoke(userBean,"hello world",10000);
            System.out.println(">>>>>>>: " + resultLeft);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
