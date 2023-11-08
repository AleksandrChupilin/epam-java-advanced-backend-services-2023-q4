package com.chupilin.javaadvancedcource.converter;

import com.chupilin.javaadvancedcource.dto.SubscriptionResponseDto;
import com.chupilin.javaadvancedcource.entity.Subscription;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubscriptionToSubscriptionResponseDtoConverter implements Converter<Subscription, SubscriptionResponseDto> {
    @Override
    public SubscriptionResponseDto convert(Subscription source) {
        return new SubscriptionResponseDto(
                source.getId(),
                source.getUser().getId(),
                toString(source.getStartDate())
        );
    }

    private String toString(LocalDate localDate) {
        return localDate == null ? null : localDate.toString();
    }

}
