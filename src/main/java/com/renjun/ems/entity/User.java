package com.renjun.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private String id;
    private String username;
    private String realname;
    private String password;
    private String sex;
}
