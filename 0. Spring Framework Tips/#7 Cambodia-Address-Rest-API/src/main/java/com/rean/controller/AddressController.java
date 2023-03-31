package com.rean.controller;

import com.rean.exception.ResponseMessage;
import com.rean.service.VillageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddressController {

    private final VillageService villageService;

    @GetMapping("village")
    public ResponseEntity<Object> uploadCommuneFile(@RequestHeader String records) {
        var message = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(villageService.villages(records));
        } catch (Exception e) {
            message = "Fetch village has error.";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }
}
