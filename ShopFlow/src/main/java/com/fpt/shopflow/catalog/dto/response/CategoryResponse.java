package com.fpt.shopflow.catalog.dto.response;

import java.time.Instant;

import com.fpt.shopflow.catalog.enums.CategoryStatus;
import lombok.Setter;

@Setter
public class CategoryResponse {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private CategoryStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
