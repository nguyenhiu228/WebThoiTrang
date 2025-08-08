package com.example.WebThoiTrang.modelDTO.product;

public class ProductSummaryDTO {
    private Integer productId;
    private String name;
    private Double price;
    private Integer stock;

    // Constructor mặc định (bắt buộc cho JPA / Jackson)
    public ProductSummaryDTO() {
    }

    // Constructor đầy đủ tham số
    public ProductSummaryDTO(Integer productId, String name, Double price, Integer stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters & Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
