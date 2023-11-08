package com.chupilin.javaadvancedcource.contorller;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.dto.UserResponseDto;
import com.chupilin.javaadvancedcource.entity.User;
import com.chupilin.javaadvancedcource.service.UserService;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        var user = conversionService.convert(userRequestDto, User.class);
        userService.save(user);
        return conversionService.convert(user, UserResponseDto.class);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {

        return null;
    }

    public void deleteUser(Long id) {

    }

    public UserResponseDto getUser(Long id) {
        return null;
    }

    public List<UserResponseDto> getAllUser() {
        return List.of();
    }
}
