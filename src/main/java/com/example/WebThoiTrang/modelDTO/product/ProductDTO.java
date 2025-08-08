package com.example.WebThoiTrang.modelDTO.product;

import java.time.LocalDateTime;

public class ProductDTO {
    private Integer productId;
    private Integer categoryId;
    private String categoryName;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String size;
    private String color;
    private String imageUrl;
    private LocalDateTime createdAt;

    public ProductDTO(Integer productId, Integer categoryId, String categoryName, String name,
                      String description, Double price, Integer stock, String size, String color,
                      String imageUrl, LocalDateTime createdAt) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.size = size;
        this.color = color;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    // Getters và Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
