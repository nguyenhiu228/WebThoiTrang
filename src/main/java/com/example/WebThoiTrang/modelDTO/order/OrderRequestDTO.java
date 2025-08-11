package com.example.WebThoiTrang.modelDTO.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public class OrderRequestDTO {
    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Tổng tiền không được để trống")
    @Positive(message = "Tổng tiền phải lớn hơn 0")
    private Double totalAmount;

    @NotNull(message = "Trạng thái không được để trống")
    @Size(min = 3, max = 50, message = "Trạng thái phải từ 3-50 ký tự")
    private String status;

    @NotNull(message = "Địa chỉ giao hàng không được để trống")
    private String shippingAddress;

    // Getters & Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}
