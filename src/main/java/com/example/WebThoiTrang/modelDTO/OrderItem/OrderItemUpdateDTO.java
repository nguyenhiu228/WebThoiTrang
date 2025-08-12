package com.example.WebThoiTrang.modelDTO.OrderItem;

public class OrderItemUpdateDTO {
    private Integer quantity;
    private Double priceAtTime;

    // Getters and Setters
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPriceAtTime() { return priceAtTime; }
    public void setPriceAtTime(Double priceAtTime) { this.priceAtTime = priceAtTime; }
}
