package com.rean.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CourseRequest {

    private Long id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("c_desc")
    private String desc;
    @JsonProperty("price")
    private BigDecimal price;
}
