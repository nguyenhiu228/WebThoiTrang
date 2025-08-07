package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.model.Product;
import com.example.WebThoiTrang.modelDTO.ProductDTO;
import com.example.WebThoiTrang.repository.ProductRepository;
import com.example.WebThoiTrang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product p = new Product(dto.getName(), dto.getPrice());
        productRepository.save(p);
        return new ProductDTO(p.getId(), p.getName(), p.getPrice());
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return productRepository.findById(id)
                .map(ProductDTO::new)
                .orElse(null);
    }
}
