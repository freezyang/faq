package com.faq.domain.category.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class CategoryDto {
    protected long parentCategoryNo;
    protected String name;

    @Getter @Setter
    @ToString
    public static class Insert extends CategoryDto { }
}
