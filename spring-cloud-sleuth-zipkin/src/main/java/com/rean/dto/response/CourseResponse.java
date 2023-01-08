package com.rean.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CourseResponse {

    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("c_desc")
    private String desc;
    @JsonProperty("price")
    private BigDecimal price;
}
