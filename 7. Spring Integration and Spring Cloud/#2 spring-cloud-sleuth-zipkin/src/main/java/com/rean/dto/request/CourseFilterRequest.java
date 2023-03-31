package com.rean.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class CourseFilterRequest extends PaginationRequest{

    private String name;
    private BigDecimal price;
}
