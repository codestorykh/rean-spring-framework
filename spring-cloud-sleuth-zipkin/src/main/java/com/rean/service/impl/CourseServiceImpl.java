package com.rean.service.impl;

import com.rean.dto.request.CourseFilterRequest;
import com.rean.dto.request.CourseRequest;
import com.rean.dto.response.CourseResponse;
import com.rean.dto.response.CourseResponsePagination;
import com.rean.dto.response.PaginationResponse;
import com.rean.exception.CourseNotFoundException;
import com.rean.exception.NoDataFoundException;
import com.rean.model.Course;
import com.rean.repository.CourseRepository;
import com.rean.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void create(CourseRequest courseRequest) {
        Course course = Course.builder()
                .id(0L)
                .name(courseRequest.getName())
                .desc(courseRequest.getDesc())
                .price(courseRequest.getPrice())
                .build();
        courseRepository.save(course);
    }

    @Override
    public void update(Long id, CourseRequest courseRequest) {
        Optional<Course> course = courseRepository.findFirstById(id);
        if(course.isPresent()){
            course.get().setId(id);
            course.get().setName(courseRequest.getName());
            course.get().setDesc(courseRequest.getDesc());
            course.get().setPrice(courseRequest.getPrice());
            courseRepository.save(course.get());
        }else {
            throw new CourseNotFoundException(id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Course> course = courseRepository.findFirstById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException(id);
        }
        course.ifPresent(courseRepository::delete);
    }

    @Override
    public CourseResponse getById(Long id) {
        Optional<Course> course = courseRepository.findFirstById(id);

        return course.map(value -> CourseResponse.builder()
                .id(value.getId())
                .name(value.getName())
                .desc(value.getDesc())
                .price(value.getPrice())
                .build()).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if(courses.isEmpty()){
            throw new NoDataFoundException();
        }
        return courses.stream().map(
                course -> CourseResponse.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .desc(course.getDesc())
                        .price(course.getPrice()).build()
        ).toList();
    }

    @Override
    public CourseResponsePagination filterWithPagination(CourseFilterRequest filterRequest) {
        if(filterRequest.getPage() == null || filterRequest.getPage() <= 0){
            filterRequest.setPaginationRequest(filterRequest.getPage(), filterRequest.getSize());
        }
        String name = filterRequest.getName();
        BigDecimal price = filterRequest.getPrice();

        int page = filterRequest.getPage() - 1;
        Page<Course> courses;
        Pageable pageable = PageRequest.of(page, filterRequest.getSize());

        if((name != null && !name.isBlank()) && price != null){
            courses = courseRepository.findAllByNameContainingIgnoreCaseAndPrice(name, price, pageable);
            return this.setCourseResponsePagination(courses, filterRequest.getPage(), filterRequest.getSize());
        }
        if(name != null && !name.isBlank()){
            courses = courseRepository.findAllByNameContainingIgnoreCase(name, pageable);
            return this.setCourseResponsePagination(courses, filterRequest.getPage(), filterRequest.getSize());
        }
        if(price != null) {
            courses = courseRepository.findAllByPrice(price, pageable);
            return this.setCourseResponsePagination(courses, filterRequest.getPage(), filterRequest.getSize());
        }
        courses = courseRepository.findAllBy(pageable);
        return this.setCourseResponsePagination(courses, filterRequest.getPage(), filterRequest.getSize());
    }

    public CourseResponsePagination setCourseResponsePagination(Page<Course> courses, int page, int size) {

        if(courses.getContent().isEmpty()){
            throw new NoDataFoundException();
        }
        List<CourseResponse> courseResponses = courses.getContent().stream().map(
                course -> CourseResponse.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .desc(course.getDesc())
                        .price(course.getPrice()).build()
        ).toList();

        PaginationResponse paginationResponse = PaginationResponse.builder()
                .current(page)
                .size(size)
                .totalPage(courses.getTotalPages())
                .records(courses.getTotalElements())
                .build();


        return CourseResponsePagination.builder()
                .courseResponses(courseResponses)
                .paginationResponse(paginationResponse)
                .build();

    }
}
