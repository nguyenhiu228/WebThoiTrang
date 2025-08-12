package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.model.Promotions;
import com.example.WebThoiTrang.modelDTO.PromotionDTO;
import com.example.WebThoiTrang.repository.PromotionRepository;
import com.example.WebThoiTrang.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
    // Chuyển từ Promotions entity sang PromotionDTO
    private PromotionDTO mapToDTO(Promotions promotion) {
        return new PromotionDTO(
                promotion.getPromotionId(),
                promotion.getCode(),
                promotion.getDescription(),
                promotion.getDiscountPercentage(),
                promotion.getStartDate(),
                promotion.getEndDate(),
                promotion.getCreatedAt()
        );
    }

    // Chuyển từ PromotionDTO sang Promotions entity
    private Promotions mapToEntity(PromotionDTO promotionDTO) {
        Promotions promotion = new Promotions();
        promotion.setPromotionId(promotionDTO.getPromotionId());
        promotion.setCode(promotionDTO.getCode());
        promotion.setDescription(promotionDTO.getDescription());
        promotion.setDiscountPercentage(promotionDTO.getDiscountPercentage());
        promotion.setStartDate(promotionDTO.getStartDate());
        promotion.setEndDate(promotionDTO.getEndDate());
        promotion.setCreatedAt(promotionDTO.getCreatedAt() != null ? promotionDTO.getCreatedAt() : LocalDateTime.now());
        return promotion;
    }
    @Override
    public PromotionDTO createPromotion(PromotionDTO promotionDTO) {
        // Kiểm tra mã code đã tồn tại chưa
        if (promotionRepository.existsByCode(promotionDTO.getCode())) {
            throw new IllegalArgumentException("Mã khuyến mãi đã tồn tại");
        }

        // Kiểm tra ngày bắt đầu và ngày kết thúc
        if (promotionDTO.getStartDate().isAfter(promotionDTO.getEndDate())) {
            throw new IllegalArgumentException("Ngày bắt đầu phải trước ngày kết thúc");
        }

        Promotions promotion = mapToEntity(promotionDTO);
        Promotions savedPromotion = promotionRepository.save(promotion);
        return mapToDTO(savedPromotion);
    }

    @Override
    public PromotionDTO updatePromotion(Integer id, PromotionDTO promotionDTO) {
        // Tìm khuyến mãi hiện có
        Promotions existingPromotion = promotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khuyến mãi với ID: " + id));

        // Kiểm tra nếu mã code thay đổi và đã tồn tại
        if (!existingPromotion.getCode().equals(promotionDTO.getCode()) &&
                promotionRepository.existsByCode(promotionDTO.getCode())) {
            throw new IllegalArgumentException("Mã khuyến mãi đã tồn tại");
        }

        // Kiểm tra ngày bắt đầu và ngày kết thúc
        if (promotionDTO.getStartDate().isAfter(promotionDTO.getEndDate())) {
            throw new IllegalArgumentException("Ngày bắt đầu phải trước ngày kết thúc");
        }

        // Cập nhật các trường
        existingPromotion.setCode(promotionDTO.getCode());
        existingPromotion.setDescription(promotionDTO.getDescription());
        existingPromotion.setDiscountPercentage(promotionDTO.getDiscountPercentage());
        existingPromotion.setStartDate(promotionDTO.getStartDate());
        existingPromotion.setEndDate(promotionDTO.getEndDate());

        Promotions updatedPromotion = promotionRepository.save(existingPromotion);
        return mapToDTO(updatedPromotion);
    }

    @Override
    public void deletePromotion(Integer id) {
        if (!promotionRepository.existsById(id)) {
            throw new IllegalArgumentException("Không tìm thấy khuyến mãi với ID: " + id);
        }
        promotionRepository.deleteById(id);
    }

    @Override
    public Optional<PromotionDTO> getPromotionById(Integer id) {
        return promotionRepository.findById(id).map(this::mapToDTO);
    }

    @Override
    public Optional<PromotionDTO> getPromotionByCode(String code) {
        return promotionRepository.findByCode(code).map(this::mapToDTO);
    }

    @Override
    public List<PromotionDTO> getAllPromotions() {
        return promotionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromotionDTO> getAllPromotionsForDisplay() {
        return promotionRepository.findAll().stream()
                .map(promotion -> new PromotionDTO(
                        promotion.getPromotionId(),
                        promotion.getCode(),
                        promotion.getDescription()
                ))
                .collect(Collectors.toList());
    }
}
