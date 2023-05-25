package com.faq.domain.category.controller;

import com.faq.domain.category.dto.CategoryDto;
import com.faq.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> insert(CategoryDto.Insert request) {
        val categoryNo = categoryService.insert(request);

        return Collections.singletonMap("id", categoryNo);
    }
}
