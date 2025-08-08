package com.example.WebThoiTrang.mapper;

import com.example.WebThoiTrang.model.Product;
import com.example.WebThoiTrang.modelDTO.product.ProductDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductListDTO;

public class ProductMapper {
    // Map Product -> ProductDTO
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getCategory().getCategoryId(),
                product.getCategory().getName(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getSize(),
                product.getColor(),
                product.getImageUrl(),
                product.getCreatedAt()
        );
    }

    // Map Product -> ProductListDTO (chỉ chứa thông tin cần thiết)
    public static ProductListDTO toProductListDTO(Product product) {
        return new ProductListDTO(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl()
        );
    }
}
