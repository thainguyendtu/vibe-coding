package com.fpt.shopflow.catalog.domain;

import java.time.Instant;

import com.fpt.shopflow.catalog.enums.CategoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Category
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Category {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private CategoryStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
