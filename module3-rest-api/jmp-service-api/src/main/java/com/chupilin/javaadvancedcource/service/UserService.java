package com.chupilin.javaadvancedcource.service;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto save(UserRequestDto user);

    UserResponseDto update(UserRequestDto user);

    void delete(Long id);

    UserResponseDto find(Long id);

    List<UserResponseDto> findAll();

}
