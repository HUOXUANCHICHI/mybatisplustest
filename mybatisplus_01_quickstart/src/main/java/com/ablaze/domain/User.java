package com.ablaze.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;

}
