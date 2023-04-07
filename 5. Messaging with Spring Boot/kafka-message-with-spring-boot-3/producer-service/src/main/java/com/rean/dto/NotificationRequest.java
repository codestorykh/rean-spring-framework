package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest{

    @JsonProperty("to_customer_id")
    Integer toCustomerId;
    @JsonProperty("to_customer_name")
    String toCustomerName;
    String message;
}