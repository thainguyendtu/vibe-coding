package com.fpt.shopflow.catalog.dto.request;

import lombok.Getter;

@Getter
public class UpdateCategoryRequest {

    private String name;
    private String slug;
    private String description;
}
