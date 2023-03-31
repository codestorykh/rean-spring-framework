package com.rean.service;


import com.rean.dto.request.CourseFilterRequest;
import com.rean.dto.request.CourseRequest;
import com.rean.dto.response.CourseResponse;
import com.rean.dto.response.CourseResponsePagination;

import java.util.List;

public interface CourseService {

    void create(CourseRequest courseRequest);
    void update(Long id, CourseRequest courseRequest);
    void delete(Long id);
    CourseResponse getById(Long id);
    List<CourseResponse> getAllCourses();
    CourseResponsePagination filterWithPagination(CourseFilterRequest filterRequest);
}
