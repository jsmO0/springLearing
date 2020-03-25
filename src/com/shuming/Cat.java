package com.shuming;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@ToString
@Component("cat")
public class Cat {
    @Autowired
    private Student student;
    @Value("123445")
    private int id;

}
