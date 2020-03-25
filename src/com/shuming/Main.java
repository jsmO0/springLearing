package com.shuming;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                  new ClassPathXmlApplicationContext("spring-config.xml");
        Cat cat = (Cat) applicationContext.getBean("cat");
        System.out.println(cat);
    }
}
