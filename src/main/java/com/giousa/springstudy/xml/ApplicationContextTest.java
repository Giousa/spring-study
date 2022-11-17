package com.giousa.springstudy.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");

        MyTestBean myTestBean = (MyTestBean) applicationContext.getBean("myTestBean");
        String testStr = myTestBean.getTestStr();
        System.out.println("myTestBean.getTestStr方法执行了。获取值："+testStr);
    }
}
