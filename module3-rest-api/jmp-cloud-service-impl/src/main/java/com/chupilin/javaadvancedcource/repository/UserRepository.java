package com.chupilin.javaadvancedcource.repository;

import com.chupilin.javaadvancedcource.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
