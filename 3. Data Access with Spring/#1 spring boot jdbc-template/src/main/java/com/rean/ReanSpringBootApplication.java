package com.rean;

import com.rean.dao.UserDao;
import com.rean.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ReanSpringBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(ReanSpringBootApplication.class, args);
    }

    @Autowired
    private UserDao userDao;

    @Bean
    void createUser() {
        UserDto dto = new UserDto();
        dto.setUsername("admin");
        dto.setPassword("1234");
        dto.setId(1);
        dto.setCrateAt(new Date());
        var user = userDao.insert(dto);
        System.out.println("Create user =>>>>" +user);
    }

    //@Bean
    void selectUser() {
        UserDto userDto = userDao.select(1);
        System.out.println(userDto);
    }

   // @Bean
    void updateUser() {
        UserDto dto = new UserDto();
        dto.setUsername("solo");
        dto.setPassword("123456");
        dto.setId(1);
        dto.setCrateAt(new Date());
        var user = userDao.update(dto);
        System.out.println("Update user =>>>>" +user);
    }

    //@Bean
    void deleteUser() {
        var user = userDao.delete(1);
        System.out.println("Delete user " + user);
    }
}
