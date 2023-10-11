package com.chupilin.javaadvancedcource.module1.repository;

import com.chupilin.javaadvancedcource.module1.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
