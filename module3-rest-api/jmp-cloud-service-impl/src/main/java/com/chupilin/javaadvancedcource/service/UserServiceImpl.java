package com.chupilin.javaadvancedcource.service;

import com.chupilin.javaadvancedcource.dto.UserRequestDto;
import com.chupilin.javaadvancedcource.dto.UserResponseDto;
import com.chupilin.javaadvancedcource.entity.User;
import com.chupilin.javaadvancedcource.repository.UserRepository;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = toUser(userRequestDto);
        user.setId(null);
        return toUserDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto) {
        Long id = userRequestDto.getId();
        User user = userRepository.findById(id)
                .map(it -> userRepository.save(toUser(userRequestDto)))
                .orElseThrow(() -> new NoSuchElementException("User with id=%s does not exist".formatted(id)));
        return toUserDto(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto find(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id=%s does not exist".formatted(id)));
        return toUserDto(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toUserDto)
                .toList();
    }

    private User toUser(UserRequestDto userRequestDto) {
        return conversionService.convert(userRequestDto, User.class);
    }

    private UserResponseDto toUserDto(User user) {
        return conversionService.convert(user, UserResponseDto.class);
    }
}
