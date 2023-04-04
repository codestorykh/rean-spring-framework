package com.rean.service;

import com.rean.dto.ResponseErrorTemplate;
import com.rean.dto.UserRequest;

public interface UserService {

    ResponseErrorTemplate create(UserRequest userRequest);
    ResponseErrorTemplate findById(Long id);
    ResponseErrorTemplate findByUsername(String username);

}
