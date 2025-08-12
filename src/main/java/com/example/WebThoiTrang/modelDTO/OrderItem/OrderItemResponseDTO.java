package com.example.WebThoiTrang.modelDTO.OrderItem;

// Dùng để trả thông tin chi tiết của OrderItem về cho Client
public class OrderItemResponseDTO {
    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double priceAtTime;
    private Double totalPrice;

    // Constructors
    public OrderItemResponseDTO() {}

    public OrderItemResponseDTO(Integer orderItemId, Integer orderId, Integer productId, String productName,
                                Integer quantity, Double priceAtTime) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceAtTime = priceAtTime;
        this.totalPrice = quantity * priceAtTime;
    }

    // Getters and Setters
    public Integer getOrderItemId() { return orderItemId; }
    public void setOrderItemId(Integer orderItemId) { this.orderItemId = orderItemId; }
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPriceAtTime() { return priceAtTime; }
    public void setPriceAtTime(Double priceAtTime) { this.priceAtTime = priceAtTime; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
