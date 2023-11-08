package com.chupilin.javaadvancedcource.contorller;

import com.chupilin.javaadvancedcource.dto.SubscriptionRequestDto;
import com.chupilin.javaadvancedcource.dto.SubscriptionResponseDto;
import com.chupilin.javaadvancedcource.service.SubscriptionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Subscription")
    public SubscriptionResponseDto createSubscription(
            @Parameter(description = "Subscription request DTO") @Valid @RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.save(subscriptionRequestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update an existing Subscription")
    public SubscriptionResponseDto updateSubscription(
            @Parameter(description = "Subscription request DTO") @Valid @RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.update(subscriptionRequestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete a Subscription")
    public void deleteSubscription(
            @Parameter(description = "Subscription ID") @PathVariable Long id) {
        subscriptionService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retrieve an existing Subscription")
    public SubscriptionResponseDto getSubscription(
            @Parameter(description = "Subscription ID") @PathVariable  Long id) {
        return subscriptionService.find(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retrieve all existing Subscriptions")
    public List<SubscriptionResponseDto> getAllSubscription() {
        return List.of();
    }
}
