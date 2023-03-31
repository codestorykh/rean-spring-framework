package com.rean.controller;

import com.rean.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/files")
@CrossOrigin()
public class MultipleFilesUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFiles(@RequestParam("files") MultipartFile[] files,
                                               @RequestHeader Map<String, String> headers) {
        try {
            return ResponseEntity.ok().body(fileUploadService.upload(files, headers));
        }catch (Exception ex) {
            log.error("Upload failed {}", ex.getLocalizedMessage());
            return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
        }
    }

}