package com.chupilin.javaadvancedcource.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequestDto {

    Long id;
    String name;
    String surname;
    @Pattern(regexp = "([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|1[1-9]|3[01])")
    String birthday;
}
