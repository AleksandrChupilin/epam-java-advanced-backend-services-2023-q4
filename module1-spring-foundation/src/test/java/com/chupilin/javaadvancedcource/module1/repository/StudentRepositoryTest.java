package com.chupilin.javaadvancedcource.module1.repository;

import com.chupilin.javaadvancedcource.module1.entity.Student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentRepositoryTest {

    private static final String TEST_NAME = "testName";
    public static final String TEST_SURNAME = "testSurname";

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void shouldSave() {
        var student = new Student(TEST_NAME, TEST_SURNAME);

        studentRepository.save(student);
        var students = studentRepository.findAll();

        assertThat(students).hasSize(1);
        assertThat(students).extracting(Student::getName).allMatch(TEST_NAME::equals);
        assertThat(students).extracting(Student::getSurname).allMatch(TEST_SURNAME::equals);
    }

}
