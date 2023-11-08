package com.chupilin.javaadvancedcource.service;

import com.chupilin.javaadvancedcource.dto.SubscriptionRequestDto;
import com.chupilin.javaadvancedcource.dto.SubscriptionResponseDto;
import com.chupilin.javaadvancedcource.entity.Subscription;
import com.chupilin.javaadvancedcource.repository.SubscriptionRepository;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ConversionService conversionService;

    @Override
    public SubscriptionResponseDto save(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = toSubscription(subscriptionRequestDto);
        subscription.setId(null);
        return toSubscriptionDto(subscriptionRepository.save(subscription));
    }

    @Override
    public SubscriptionResponseDto update(SubscriptionRequestDto subscriptionRequestDto) {
        Long id = subscriptionRequestDto.getId();
        Subscription subscription = subscriptionRepository.findById(id)
                .map(it -> subscriptionRepository.save(toSubscription(subscriptionRequestDto)))
                .orElseThrow(() -> new NoSuchElementException("Subscription with id=%s does not exist".formatted(id)));
        return toSubscriptionDto(subscription);
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public SubscriptionResponseDto find(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Subscription with id=%s does not exist".formatted(id)));
        return toSubscriptionDto(subscription);
    }

    @Override
    public List<SubscriptionResponseDto> findAll() {
        return subscriptionRepository.findAll()
                .stream()
                .map(this::toSubscriptionDto)
                .toList();
    }

    private Subscription toSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return conversionService.convert(subscriptionRequestDto, Subscription.class);
    }

    private SubscriptionResponseDto toSubscriptionDto(Subscription subscription) {
        return conversionService.convert(subscription, SubscriptionResponseDto.class);
    }
}
