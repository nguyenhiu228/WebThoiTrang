package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.mapper.ProductMapper;
import com.example.WebThoiTrang.model.Category;
import com.example.WebThoiTrang.model.Product;
import com.example.WebThoiTrang.modelDTO.product.ProductDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductListDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductRequest;
import com.example.WebThoiTrang.modelDTO.product.ProductSummaryDTO;
import com.example.WebThoiTrang.repository.CategoryRepository;
import com.example.WebThoiTrang.repository.ProductRepository;
import com.example.WebThoiTrang.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toProductDTO)
                .toList();
    }

    @Override
    public List<ProductListDTO> getProductList() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toProductListDTO)
                .toList();
    }

    @Override
    public Optional<ProductDTO> getProductById(Integer id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductDTO);
    }

    @Override
    public ProductDTO createProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category không tồn tại"));

        Product product = new Product(
                category,
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getStock(),
                request.getSize(),
                request.getColor(),
                request.getImageUrl()
        );

        Product saved = productRepository.save(product);
        return ProductMapper.toProductDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product không tồn tại"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category không tồn tại"));

        existing.setCategory(category);
        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setStock(request.getStock());
        existing.setSize(request.getSize());
        existing.setColor(request.getColor());
        existing.setImageUrl(request.getImageUrl());

        Product updated = productRepository.save(existing);
        return ProductMapper.toProductDTO(updated);
    }

    @Override
    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product không tồn tại");
        }
        productRepository.deleteById(id);
    }

    @Override
    public Optional<ProductSummaryDTO> getProductSummary(Integer id) {
        return productRepository.findById(id)
                .map(product -> new ProductSummaryDTO(
                        product.getProductId(),
                        product.getName(),
                        product.getPrice(),
                        product.getStock()
                ));
    }

    @Override
    public List<ProductListDTO> searchProductsByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(ProductMapper::toProductListDTO)
                .toList();
    }

    @Override
    public List<ProductListDTO> getProductsByCategory(Integer categoryId) {
        return productRepository.findByCategory_CategoryId(categoryId)
                .stream()
                .map(ProductMapper::toProductListDTO)
                .toList();
    }
}
