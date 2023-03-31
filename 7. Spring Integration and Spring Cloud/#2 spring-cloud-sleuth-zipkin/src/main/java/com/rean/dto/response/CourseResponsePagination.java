package com.rean.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseResponsePagination {

    @JsonProperty("courses")
    private List<CourseResponse> courseResponses;

    @JsonProperty("page_detail")
    private PaginationResponse paginationResponse;

}
