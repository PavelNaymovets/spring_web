package com.naumovets.spring.web.repositories;

import com.naumovets.spring.web.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(List.of(
                new Student(1L, "Bob"),
                new Student(2L, "Michael"),
                new Student(1L, "Ivan")
        ));
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public Student findById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
