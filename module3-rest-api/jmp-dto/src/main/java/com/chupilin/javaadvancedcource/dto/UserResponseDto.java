package com.chupilin.javaadvancedcource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    Long id;
    String name;
    String surname;
    String birthday;
}
