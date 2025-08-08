package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.category.CategoryDTO;
import com.example.WebThoiTrang.modelDTO.category.CategoryRequest;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    // Lấy toàn bộ danh sách categories (trả về DTO)
    List<CategoryDTO> getAllCategories();

    // Lấy category theo ID (trả về DTO)
    Optional<CategoryDTO> getCategoryById(Integer id);

    // Tạo mới category (trả về entity để biết ID vừa tạo)
    CategoryDTO createCategory(CategoryRequest request);

    CategoryDTO updateCategory(Integer id, CategoryRequest request);

    // Xóa category theo ID
    void deleteCategory(Integer id);

    // Đếm số sản phẩm thuộc một category
    long countProductsInCategory(Integer categoryId);
}
