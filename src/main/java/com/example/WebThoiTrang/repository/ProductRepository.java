package com.example.WebThoiTrang.repository;

import com.example.WebThoiTrang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    long countByCategoryCategoryId(Integer categoryId);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findByCategory_CategoryId(Integer categoryId);
}
