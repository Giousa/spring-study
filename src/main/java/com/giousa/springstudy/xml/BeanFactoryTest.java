package com.giousa.springstudy.xml;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));

        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

        String str = myTestBean.getTestStr();

        System.out.println("result >>>> "+str);
    }

}
