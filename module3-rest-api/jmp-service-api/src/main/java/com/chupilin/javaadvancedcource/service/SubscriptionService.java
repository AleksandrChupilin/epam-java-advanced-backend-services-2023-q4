package com.chupilin.javaadvancedcource.service;

import com.chupilin.javaadvancedcource.dto.SubscriptionRequestDto;
import com.chupilin.javaadvancedcource.dto.SubscriptionResponseDto;
import com.chupilin.javaadvancedcource.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    SubscriptionResponseDto save(SubscriptionRequestDto user);

    SubscriptionResponseDto update(SubscriptionRequestDto user);

    void delete(Long id);

    SubscriptionResponseDto find(Long id);

    List<SubscriptionResponseDto> findAll();
    
}
