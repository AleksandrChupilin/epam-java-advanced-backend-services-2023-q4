package com.chupilin.javaadvancedcource.repository;

import com.chupilin.javaadvancedcource.entity.Subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
