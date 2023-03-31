package com.rean.service;

import com.rean.dto.VillageResponseDto;
import com.rean.model.Village;
import com.rean.repository.VillageRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VillageService {

    private final VillageRepository villageRepository;
    private final ModelMapper modelMapper;

    public VillageService(VillageRepository villageRepository, ModelMapper modelMapper) {
        this.villageRepository = villageRepository;
        this.modelMapper = modelMapper;
    }

    public List<VillageResponseDto> villages(String records) {
        StopWatch watch = new StopWatch();
        watch.start();

        Pageable pageable = PageRequest.of(0, Integer.parseInt(records));
        Page<Village> villagePage = villageRepository.findAll(pageable);
        List<VillageResponseDto> villageResponse = villagePage.stream()
                .map(village -> modelMapper.map(village, VillageResponseDto.class))
                .collect(Collectors.toList());
        watch.stop();
        log.info("Get villages {} from db time Elapsed: {}", villageResponse.size(), watch.getTotalTimeSeconds());
        return villageResponse;
    }
}
