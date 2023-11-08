package com.chupilin.javaadvancedcource.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

    Long id;
    String name;
    String surname;
    LocalDate birthday;
}
