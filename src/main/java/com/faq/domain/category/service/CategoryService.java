package com.faq.domain.category.service;

import com.faq.domain.category.dto.CategoryDto;
import com.faq.domain.category.entity.Category;
import com.faq.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public long insert(CategoryDto.Insert request) {
        Category category = new Category();
        category.setParentCategoryNo(request.getParentCategoryNo());
        category.setName(request.getName());

        categoryRepository.save(category);

        return category.getCategoryNo();
    }
}
