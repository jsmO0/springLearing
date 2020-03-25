package com.shuming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {
    private String Sname;
    private Integer id;

    public void doInit(){
        System.out.println("初始化操作......");
    }

    public void doClose(){
        System.out.println("close.......");
    }
}
