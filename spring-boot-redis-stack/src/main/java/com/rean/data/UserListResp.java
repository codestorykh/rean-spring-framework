package com.rean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserListResp {

    @JsonProperty("users")
    private List<User> users;
}
