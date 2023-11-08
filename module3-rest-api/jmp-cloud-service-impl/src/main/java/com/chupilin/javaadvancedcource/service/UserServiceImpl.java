package com.chupilin.javaadvancedcource.service;

import com.chupilin.javaadvancedcource.entity.User;
import com.chupilin.javaadvancedcource.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User find(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id=%s does not exist".formatted(id)));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
