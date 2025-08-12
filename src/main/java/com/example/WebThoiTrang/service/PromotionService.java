package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.PromotionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PromotionService {
    // Tạo mới khuyến mãi
    PromotionDTO createPromotion(PromotionDTO promotionDTO);

    // Cập nhật khuyến mãi
    PromotionDTO updatePromotion(Integer id, PromotionDTO promotionDTO);

    // Xóa khuyến mãi theo ID
    void deletePromotion(Integer id);

    // Lấy khuyến mãi theo ID
    Optional<PromotionDTO> getPromotionById(Integer id);

    // Lấy khuyến mãi theo mã code
    Optional<PromotionDTO> getPromotionByCode(String code);

    // Lấy tất cả khuyến mãi
    List<PromotionDTO> getAllPromotions();

    // Lấy danh sách khuyến mãi để hiển thị trên front-end (chỉ ID, code, description)
    List<PromotionDTO> getAllPromotionsForDisplay();
}
