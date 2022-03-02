package com.rean.service.impl;

import com.rean.dto.PhotoRequestDto;
import com.rean.model.Photo;
import com.rean.repository.PhotoRepository;
import com.rean.service.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PhotoServiceImpl implements PhotoService {

    private final ModelMapper modelMapper;
    private final PhotoRepository photoRepository;

    @Override
    public void addNewPhoto(PhotoRequestDto photoRequestDto) throws Exception {
        Photo photo = photoRepository.save(modelMapper.map(photoRequestDto, Photo.class));
        if(Objects.isNull(photo.getId())) {
            log.error("Saving new photo was failed!");
            throw new Exception();
        }
    }

    @Override
    public Photo checkById(Long id) {
        Optional<Photo> photo = photoRepository.findFirstById(id);
        return photo.orElse(null);
    }
}
