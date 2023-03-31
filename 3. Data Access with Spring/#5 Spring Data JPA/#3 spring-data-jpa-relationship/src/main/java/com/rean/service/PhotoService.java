package com.rean.service;

import com.rean.dto.PhotoRequestDto;
import com.rean.model.Photo;

public interface PhotoService {

    void addNewPhoto(PhotoRequestDto photoRequestDto) throws Exception;

    Photo checkById(Long id);
}
