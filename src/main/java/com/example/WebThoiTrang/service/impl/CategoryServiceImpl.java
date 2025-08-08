package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.model.Category;
import com.example.WebThoiTrang.modelDTO.category.CategoryDTO;
import com.example.WebThoiTrang.modelDTO.category.CategoryRequest;
import com.example.WebThoiTrang.repository.CategoryRepository;
import com.example.WebThoiTrang.repository.ProductRepository;
import com.example.WebThoiTrang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;  // Để đếm số sản phẩm trong category

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
            return categories.stream()
                .map(cat -> new CategoryDTO(
                        cat.getCategoryId(),
                        cat.getName(),
                        cat.getDescription(),
                        cat.getCreatedAt(),
                        productRepository.countByCategoryCategoryId(cat.getCategoryId())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(cat -> new CategoryDTO(
                        cat.getCategoryId(),
                        cat.getName(),
                        cat.getDescription(),
                        cat.getCreatedAt(),
                        productRepository.countByCategoryCategoryId(cat.getCategoryId())
                ));
    }

    @Override
    public CategoryDTO createCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setCreatedAt(LocalDateTime.now());

        Category saved = categoryRepository.save(category);

        return new CategoryDTO(
                saved.getCategoryId(),
                saved.getName(),
                saved.getDescription(),
                saved.getCreatedAt(),
                0L // productCount mặc định 0 khi mới tạo
        );
    }

    @Override
    public CategoryDTO updateCategory(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category không tồn tại"));

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category updated = categoryRepository.save(category);

        // Nếu có countProductsInCategory thì lấy ở đây
        Long productCount = countProductsInCategory(updated.getCategoryId());

        return new CategoryDTO(
                updated.getCategoryId(),
                updated.getName(),
                updated.getDescription(),
                updated.getCreatedAt(),
                productCount
        );
    }

    @Override
    public void deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }

    @Override
    public long countProductsInCategory(Integer categoryId) {
        return productRepository.countByCategoryCategoryId(categoryId);
    }
}
