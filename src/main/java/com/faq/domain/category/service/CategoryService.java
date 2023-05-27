package com.faq.domain.category.service;

import com.faq.domain.category.dto.CategoryDto;
import com.faq.domain.category.entity.Category;
import com.faq.domain.category.event.CategoryEvent;
import com.faq.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public long insert(CategoryDto.Insert request) {
        Category category = new Category();
        category.setParentCategoryNo(request.getParentCategoryNo());
        category.setName(request.getName());

        categoryRepository.save(category);

        return category.getCategoryNo();
    }

    @Transactional
    public void update(long categoryNo, CategoryDto.Modify request) {
        Optional<Category> category = categoryRepository.findById(categoryNo);

        category.ifPresent(it -> {
            it.setName(request.getName());
            it.setParentCategoryNo(request.getParentCategoryNo());
        });
    }

    @Transactional
    public void delete(long categoryNo) {
        categoryRepository.deleteById(categoryNo);

        applicationEventPublisher.publishEvent(new CategoryEvent(categoryNo));
    }

    @Transactional(readOnly = true)
    public List<CategoryDto.List> findCategories() {
        return categoryRepository.findAll().stream()
                .map(it -> {
                    CategoryDto.List categoryDto = new CategoryDto.List();
                    categoryDto.setCategoryNo(it.getCategoryNo());
                    categoryDto.setParentCategoryNo(it.getParentCategoryNo());
                    categoryDto.setName(it.getName());
                    return categoryDto;
                })
                .collect(Collectors.toList());
    }
}
