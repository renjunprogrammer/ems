package com.renjun.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Emp {
    private String id;
    private String name;
    private String salary;
    private int age;
}
