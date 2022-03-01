package com.learnspring.controller;

import com.learnspring.dto.CourseDto;
import com.learnspring.dto.StudentCourseDto;
import com.learnspring.model.Course;
import com.learnspring.repository.CourseRepository;
import com.learnspring.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @GetMapping("students")
    public List<StudentCourseDto> getAllUsersLocation() {
        return studentCourseService.getAllStudentsCourse();
    }

    @GetMapping("lazy-eager")
    public List<CourseDto> courses() {
        return studentCourseService.getAllCourses();
    }

}
