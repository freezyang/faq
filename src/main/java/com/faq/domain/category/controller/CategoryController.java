package com.faq.domain.category.controller;

import com.faq.domain.category.dto.CategoryDto;
import com.faq.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequestMapping("/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Long> insert(@RequestBody CategoryDto.Insert request) {
        val categoryNo = categoryService.insert(request);

        return Collections.singletonMap("id", categoryNo);
    }

    @PutMapping(path = "/{categoryNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable long categoryNo, @RequestBody CategoryDto.Modify request) {
        categoryService.update(categoryNo, request);
    }

    @DeleteMapping(path = "/{categoryNo}")
    void delete(@PathVariable long categoryNo) {
        categoryService.delete(categoryNo);
    }

    @GetMapping
    List<CategoryDto.List> getList() {
        return categoryService.findCategories();
    }
}
