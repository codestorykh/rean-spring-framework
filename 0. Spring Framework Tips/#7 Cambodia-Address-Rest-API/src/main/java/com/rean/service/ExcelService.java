package com.rean.service;

import com.rean.model.Commune;
import com.rean.model.Village;
import com.rean.repository.CommuneRepository;
import com.rean.repository.VillageRepository;
import com.rean.utils.ExcelCommuneHelper;
import com.rean.utils.ExcelVillageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExcelService {

    private final VillageRepository villageRepository;
    private final CommuneRepository communeRepository;

    public void saveCommunes(MultipartFile file) {
        try {
            List<Commune> communes = ExcelCommuneHelper.excelToCommunes(file.getInputStream());
            StopWatch watch = new StopWatch();
            watch.start();
            communeRepository.saveAll(communes);
            watch.stop();
            log.info("Save communes {} time Elapsed: {}", communes.size(), watch.getTotalTimeSeconds());
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public void saveVillages(MultipartFile file) {
        try {
            List<Village> villages = ExcelVillageHelper.excelToVillages(file.getInputStream());
            StopWatch watch = new StopWatch();
            watch.start();
            villageRepository.saveAll(villages);
            watch.stop();
            log.info("Save villages {} time Elapsed: {}", villages.size(), watch.getTotalTimeSeconds());
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}