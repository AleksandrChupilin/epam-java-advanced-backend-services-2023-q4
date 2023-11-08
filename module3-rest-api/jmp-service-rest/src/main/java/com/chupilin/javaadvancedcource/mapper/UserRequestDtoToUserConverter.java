package com.chupilin.javaadvancedcource.mapper;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.entity.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoToUserConverter implements Converter<UserRequestDto, User> {
    @Override
    public User convert(UserRequestDto source) {
        return null;
    }
}
