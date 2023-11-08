package com.chupilin.javaadvancedcource.converter;

import com.chupilin.javaadvancedcource.dto.UserResponseDto;
import com.chupilin.javaadvancedcource.entity.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(User source) {
        return new UserResponseDto(
                source.getId(),
                source.getName(),
                source.getSurname(),
                toString(source.getBirthday())
        );
    }

    private String toString(LocalDate localDate) {
        return localDate == null ? null : localDate.toString();
    }

}
