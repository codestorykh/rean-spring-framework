package com.rean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<Object> getUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new User(
                        "rean",
                        "code",
                        "reancode@gmail.com")
                );
    }

}
