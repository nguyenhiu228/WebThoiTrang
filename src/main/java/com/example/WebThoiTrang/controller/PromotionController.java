package com.example.WebThoiTrang.controller;

import com.example.WebThoiTrang.modelDTO.PromotionDTO;
import com.example.WebThoiTrang.modelDTO.UserDTO;
import com.example.WebThoiTrang.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    PromotionService promotionService;

    //Create
    // Tạo mới khuyến mãi
    @PostMapping
    public ResponseEntity<PromotionDTO> createPromotion(@Valid @RequestBody PromotionDTO promotionDTO) {
        // Tạo PromotionDTO mới với createdAt được gán thời gian hiện tại
        PromotionDTO createDTO = new PromotionDTO(
                promotionDTO.getCode(),
                promotionDTO.getDescription(),
                promotionDTO.getDiscountPercentage(),
                promotionDTO.getStartDate(),
                promotionDTO.getEndDate()
        );
        createDTO.setCreatedAt(LocalDateTime.now()); // Gán thời gian hiện tại
        PromotionDTO createdPromotion = promotionService.createPromotion(createDTO);
        return new ResponseEntity<>(createdPromotion, HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/{id}")
    /*public ResponseEntity<PromotionDTO> updatePromotion(@PathVariable Integer id, @Valid @RequestBody PromotionDTO promotionDTO) {
        PromotionDTO updatedPromotion = promotionService.updatePromotion(id, promotionDTO);
        return ResponseEntity.ok(updatedPromotion);
    }*/
    public ResponseEntity<PromotionDTO> updatePromotion(@PathVariable Integer id, @Valid @RequestBody PromotionDTO promotionDTO) {
        // Sử dụng constructor dành cho cập nhật
        PromotionDTO updateDTO = new PromotionDTO(
                id, // Gán ID từ path variable
                promotionDTO.getCode(),
                promotionDTO.getDescription(),
                promotionDTO.getDiscountPercentage(),
                promotionDTO.getStartDate(),
                promotionDTO.getEndDate()
        );
        PromotionDTO updatedPromotion = promotionService.updatePromotion(id, updateDTO);
        return ResponseEntity.ok(updatedPromotion);
    }


    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Integer id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.noContent().build();
    }
    // Lấy khuyến mãi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getPromotionById(@PathVariable Integer id) {
        return promotionService.getPromotionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy khuyến mãi theo mã code
    @GetMapping("/code/{code}")
    public ResponseEntity<PromotionDTO> getPromotionByCode(@PathVariable String code) {
        return promotionService.getPromotionByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy tất cả khuyến mãi
    @GetMapping
    public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
        List<PromotionDTO> promotions = promotionService.getAllPromotions();
        return ResponseEntity.ok(promotions);
    }

    // Lấy danh sách khuyến mãi cho front-end (chỉ ID, code, description)
    @GetMapping("/display")
    public ResponseEntity<List<PromotionDTO>> getAllPromotionsForDisplay() {
        List<PromotionDTO> promotions = promotionService.getAllPromotionsForDisplay();
        return ResponseEntity.ok(promotions);
    }
}
