package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data //自动生成get set方法
@NoArgsConstructor //自动生成无参构造器
@AllArgsConstructor //自动生成全参构造器
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    private String name;
    private Integer age;
}
