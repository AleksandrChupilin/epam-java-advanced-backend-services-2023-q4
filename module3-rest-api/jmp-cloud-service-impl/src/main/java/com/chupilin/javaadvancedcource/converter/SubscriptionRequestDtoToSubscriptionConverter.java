package com.chupilin.javaadvancedcource.converter;

import com.chupilin.javaadvancedcource.dto.SubscriptionRequestDto;
import com.chupilin.javaadvancedcource.entity.Subscription;
import com.chupilin.javaadvancedcource.entity.User;
import com.chupilin.javaadvancedcource.repository.UserRepository;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SubscriptionRequestDtoToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

    private final UserRepository userRepository;

    @Override
    public Subscription convert(SubscriptionRequestDto source) {
        User user = userRepository.findById(source.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User with id=%s does not exist"));
        return new Subscription(
                source.getId(),
                user,
                LocalDate.now());
    }
}
