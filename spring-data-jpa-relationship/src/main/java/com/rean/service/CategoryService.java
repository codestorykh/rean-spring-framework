package com.rean.service;

import com.rean.dto.CategoryRequestDto;
import com.rean.model.Category;

public interface CategoryService {

    void createNewCategory(CategoryRequestDto categoryRequestDto) throws Exception;

    Category checkById(Long id) throws Exception;
}
