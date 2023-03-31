package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {

    @JsonProperty("category")
    private String category;

    @JsonProperty("description")
    private String description;
}
