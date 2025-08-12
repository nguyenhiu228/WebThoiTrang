package com.example.WebThoiTrang.repository;

import com.example.WebThoiTrang.model.Promotions;
import com.example.WebThoiTrang.model.User;
import com.example.WebThoiTrang.modelDTO.PromotionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotions, Integer> {
    Optional<Promotions> findByCode(String code);
    boolean existsByCode(String code);
}
