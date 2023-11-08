package com.chupilin.javaadvancedcource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponseDto {

    Long id;
    Long userId;
    String startDate;
}
