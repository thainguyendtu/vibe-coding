package com.fpt.shopflow.catalog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Product
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Product {

    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private ProductStatus status;
    private Long categoryId;
    private Instant createdAt;
    private Instant updatedAt;
}
