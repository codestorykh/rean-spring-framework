package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VillageResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name_kh")
    private String khName;

    @JsonProperty("name_en")
    private String enName;
}
