package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    @JsonProperty("to_customer")
    private Integer toCustomerId;
    @JsonProperty("to_email")
    private String toCustomerEmail;
    private String message;

}
