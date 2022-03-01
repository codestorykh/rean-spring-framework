package com.learnspring.service;

import com.learnspring.dto.CourseDto;
import com.learnspring.dto.StudentCourseDto;
import com.learnspring.model.Course;
import com.learnspring.model.Student;
import com.learnspring.repository.CourseRepository;
import com.learnspring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentCourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public List<StudentCourseDto> getAllStudentsCourse() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::convertToStudentCourseDtoWithModelMapper)
                .collect(Collectors.toList());
    }

    private StudentCourseDto convertToStudentCourseDtoWithModelMapper(Student student) {
        return modelMapper
                .map(student, StudentCourseDto.class);
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository
                .findAll()
                .stream()
                .map(this::convertToStudentCourseDto)
                .collect(Collectors.toList());
    }

    private CourseDto convertToStudentCourseDto(Course course) {
        return modelMapper
                .map(course, CourseDto.class);
    }
}
