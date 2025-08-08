package com.example.WebThoiTrang.modelDTO.category;

import java.time.LocalDateTime;

public class CategoryDTO {
    private Integer categoryId;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Long productCount;

    public CategoryDTO(Integer categoryId, String name, String description, LocalDateTime createdAt, Long productCount) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.productCount = productCount;
    }

    // Getter
    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getProductCount() {
        return productCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setter
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
