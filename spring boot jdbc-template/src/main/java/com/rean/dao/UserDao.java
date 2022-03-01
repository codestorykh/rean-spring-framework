package com.rean.dao;

import com.rean.dto.UserDto;

public interface UserDao {

    int insert(UserDto userDto);
    int update(UserDto userDto);
    UserDto select(int id);
    int delete(int id);
}
