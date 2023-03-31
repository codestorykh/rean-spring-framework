package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdReq implements Serializable {

    private static final long serialVersionUID = -8571454453894445935L;
    @JsonProperty("employees")
    private List<Long> id;
}
