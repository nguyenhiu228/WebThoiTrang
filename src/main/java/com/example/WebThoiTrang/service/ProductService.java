package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.ProductDTO;

public interface ProductService {
    ProductDTO createProduct(ProductDTO dto);
    ProductDTO getProduct(Long id);
}
