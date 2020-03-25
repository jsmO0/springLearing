package com.shuming;

import lombok.ToString;

@ToString
public class Dog {
    private String name;
    private User user;
    public Dog(String name, User user){
        this.name = name;
        this.user = user;
    }
}
