package com.rean.service.impl;

import com.rean.dto.CategoryRequestDto;
import com.rean.model.Category;
import com.rean.repository.CategoryRepository;
import com.rean.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CategoryRequestDto categoryRequestDto) throws Exception {
        Category category = categoryRepository.save(modelMapper.map(categoryRequestDto, Category.class));
        if (Objects.isNull(category.getId())) {
            log.error("Saving new category was failed!");
            throw new Exception();
        }
    }

    @Override
    public Category checkById(Long id) {
        Optional<Category> category = categoryRepository.findFirstById(id);
        return category.orElse(null);
    }
}
