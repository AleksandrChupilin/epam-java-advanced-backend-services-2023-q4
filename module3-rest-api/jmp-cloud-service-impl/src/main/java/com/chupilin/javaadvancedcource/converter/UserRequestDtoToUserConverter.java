package com.chupilin.javaadvancedcource.converter;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.entity.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserRequestDtoToUserConverter implements Converter<UserRequestDto, User> {
    @Override
    public User convert(UserRequestDto source) {
        return new User(
                source.getId(),
                source.getName(),
                source.getSurname(),
                LocalDate.parse(source.getBirthday()));
    }
}
