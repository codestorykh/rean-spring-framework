package com.rean.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationResponse {

    @JsonProperty("total_pages")
    private int totalPage;

    @JsonProperty("current")
    private int current;

    @JsonProperty("size")
    private int size;

    @JsonProperty("records")
    private long records;

}
