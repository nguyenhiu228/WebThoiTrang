package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.product.ProductDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductListDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductRequest;
import com.example.WebThoiTrang.modelDTO.product.ProductSummaryDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // Lấy tất cả sản phẩm (đầy đủ thông tin)
    List<ProductDTO> getAllProducts();

    // Lấy danh sách sản phẩm (dùng cho trang list hiển thị)
    List<ProductListDTO> getProductList();

    // Lấy sản phẩm theo ID (đầy đủ thông tin)
    Optional<ProductDTO> getProductById(Integer id);

    // Tạo sản phẩm mới (dùng Request DTO để validate input)
    ProductDTO createProduct(ProductRequest request);

    // Cập nhật sản phẩm
    ProductDTO updateProduct(Integer id, ProductRequest request);

    // Xóa sản phẩm
    void deleteProduct(Integer id);

    // Lấy thống kê sản phẩm (ví dụ số lượng bán + doanh thu)
    Optional<ProductSummaryDTO> getProductSummary(Integer id);

    // Tìm kiếm sản phẩm theo tên
    List<ProductListDTO> searchProductsByName(String keyword);

    // Lấy danh sách sản phẩm theo category
    List<ProductListDTO> getProductsByCategory(Integer categoryId);
}
