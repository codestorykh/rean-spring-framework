package com.rean.controller;

import com.rean.exception.ResponseMessage;
import com.rean.service.ExcelService;
import com.rean.utils.ExcelCommuneHelper;
import com.rean.utils.ExcelVillageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("commune/upload")
    public ResponseEntity<Object> uploadCommuneFile(@RequestParam("file") MultipartFile file) {
        var message = "";
        if (ExcelCommuneHelper.hasExcelFormat(file)) {
            try {
                excelService.saveCommunes(file);
                message = "Uploaded the file commune successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the commune file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @PostMapping("village/upload")
    public ResponseEntity<Object> uploadVillageFile(@RequestParam("file") MultipartFile file) {
        var message = "";
        if (ExcelVillageHelper.hasExcelFormat(file)) {
            try {
                excelService.saveVillages(file);
                message = "Uploaded the village file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the village file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}