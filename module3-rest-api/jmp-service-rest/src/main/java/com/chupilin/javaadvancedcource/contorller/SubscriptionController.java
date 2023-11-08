package com.chupilin.javaadvancedcource.contorller;

import com.chupilin.javaadvancedcource.dto.SubscriptionRequestDto;
import com.chupilin.javaadvancedcource.dto.SubscriptionResponseDto;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionController {


    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return null;
    }

    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return null;
    }

    public void deleteSubscription(Long id) {

    }

    public SubscriptionResponseDto getSubscription(Long id) {
        return null;
    }

    public List<SubscriptionResponseDto> getAllSubscription() {
        return List.of();
    }
}
