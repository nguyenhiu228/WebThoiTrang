package com.example.WebThoiTrang.modelDTO.OrderItem;

public class OrderItemCreateDTO {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double priceAtTime;

    // Getters and Setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPriceAtTime() { return priceAtTime; }
    public void setPriceAtTime(Double priceAtTime) { this.priceAtTime = priceAtTime; }
}
