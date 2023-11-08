package com.chupilin.javaadvancedcource.mapper;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.dto.UserResponseDto;
import com.chupilin.javaadvancedcource.entity.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(User source) {
        return null;
    }
}
