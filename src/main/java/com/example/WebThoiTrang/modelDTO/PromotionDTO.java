package com.example.WebThoiTrang.modelDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class PromotionDTO {
    private Integer promotionId;

    @NotBlank(message = "Code cannot be blank")
    private String code;

    private String description;

    @Positive(message = "Discount percentage must be positive")
    private Double discountPercentage;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;

    // Constructor mặc định
    public PromotionDTO() {}

    // Constructor đầy đủ (cho lấy dữ liệu)
    public PromotionDTO(Integer promotionId, String code, String description,
                        Double discountPercentage, LocalDateTime startDate,
                        LocalDateTime endDate, LocalDateTime createdAt) {
        this.promotionId = promotionId;
        this.code = code;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
    }

    // Constructor cho tạo mới (create): Không cần promotionId và createdAt
    public PromotionDTO(String code, String description, Double discountPercentage,
                        LocalDateTime startDate, LocalDateTime endDate) {
        this.code = code;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Constructor cho cập nhật (update): Bao gồm tất cả trừ createdAt
    public PromotionDTO(Integer promotionId, String code, String description,
                        Double discountPercentage, LocalDateTime startDate,
                        LocalDateTime endDate) {
        this.promotionId = promotionId;
        this.code = code;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Constructor cho hiển thị ở front-end Id, code và decription
    public PromotionDTO(Integer promotionId, String code, String description){
        this.promotionId = promotionId;
        this.code = code;
        this.description = description;
    }

    // Getters and Setters
    public Integer getPromotionId() { return promotionId; }
    public void setPromotionId(Integer promotionId) { this.promotionId = promotionId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
