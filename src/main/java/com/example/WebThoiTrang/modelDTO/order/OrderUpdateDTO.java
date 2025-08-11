package com.example.WebThoiTrang.modelDTO.order;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class OrderUpdateDTO {
    @Positive(message = "Tổng tiền phải lớn hơn 0")
    private Double totalAmount;

    @Size(min = 3, max = 50, message = "Trạng thái phải từ 3-50 ký tự")
    private String status;

    private String shippingAddress;

    // Getters & Setters
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}
