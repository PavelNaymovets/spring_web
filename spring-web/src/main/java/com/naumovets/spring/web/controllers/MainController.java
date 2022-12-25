package com.naumovets.spring.web.controllers;

import com.naumovets.spring.web.model.Student;
import com.naumovets.spring.web.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam(name = "param_a") int a, @RequestParam(name = "param_b") int b) {
        return a+b;
    }

    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable long id) {
        return "Product #" + id;
    }

    @GetMapping("/students")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentRepository.getStudents());
        return "students_page";
    }

    @GetMapping("/students/{id}")
    public String showStudentInfo(Model model, @PathVariable Long id) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "studentsInfo_page";
    }

}
