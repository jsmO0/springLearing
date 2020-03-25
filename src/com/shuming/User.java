package com.shuming;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@ToString
public class User {

    private Student student;
    private String username;

    public void say(){
        System.out.println(username +" is a chinese,and make him feel proud.");
    }
}
