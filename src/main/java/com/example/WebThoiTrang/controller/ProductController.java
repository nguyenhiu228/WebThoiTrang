package com.example.WebThoiTrang.controller;

import com.example.WebThoiTrang.modelDTO.product.ProductDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductListDTO;
import com.example.WebThoiTrang.modelDTO.product.ProductRequest;
import com.example.WebThoiTrang.modelDTO.product.ProductSummaryDTO;
import com.example.WebThoiTrang.service.FileStorageService;
import com.example.WebThoiTrang.service.ProductService;
import com.example.WebThoiTrang.service.impl.FileStorageServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    private final FileStorageServiceImpl fileStorageService;

    public ProductController(ProductService productService, FileStorageServiceImpl fileStorageService) {
        this.productService = productService;
        this.fileStorageService = fileStorageService;
    }

    // Lấy danh sách đầy đủ sản phẩm (bao gồm chi tiết)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Lấy danh sách rút gọn sản phẩm (ví dụ cho trang home)
    @GetMapping("/list")
    public ResponseEntity<List<ProductListDTO>> getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }

    // Lấy thông tin chi tiết sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Lấy tóm tắt thông tin sản phẩm
    @GetMapping("/{id}/summary")
    public ResponseEntity<ProductSummaryDTO> getProductSummary(@PathVariable Integer id) {
        return productService.getProductSummary(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tìm kiếm sản phẩm theo tên
    @GetMapping("/search")
    public ResponseEntity<List<ProductListDTO>> searchProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchProductsByName(keyword));
    }

    // Lấy sản phẩm theo category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductListDTO>> getProductsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    // Tạo sản phẩm mới
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> createProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("stock") Integer stock,
            @RequestParam("categoryId") Integer categoryId,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = fileStorageService.storeFile(image);
        }

        ProductRequest request = new ProductRequest();
        request.setName(name);
        request.setPrice(price);
        request.setStock(stock);
        request.setCategoryId(categoryId);
        request.setDescription(description);
        request.setSize(size);
        request.setColor(color);
        request.setImageUrl(imageUrl);

        return ResponseEntity.ok(productService.createProduct(request));
    }

    // Cập nhật sản phẩm
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Integer id,
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("stock") Integer stock,
            @RequestParam("categoryId") Integer categoryId,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) {
        String imageUrl = null;

        // Nếu có ảnh mới thì lưu ảnh
        if (image != null && !image.isEmpty()) {
            imageUrl = fileStorageService.storeFile(image);
        } else {
            // Không có ảnh mới -> giữ ảnh cũ
            imageUrl = productService.getProductById(id)
                    .map(ProductDTO::getImageUrl) // lấy ảnh cũ
                    .orElse(null); // nếu không có thì để null
        }

        // Tạo request object để gửi xuống service
        ProductRequest request = new ProductRequest();
        request.setName(name);
        request.setPrice(price);
        request.setStock(stock);
        request.setCategoryId(categoryId);
        request.setDescription(description);
        request.setSize(size);
        request.setColor(color);
        request.setImageUrl(imageUrl);

        return ResponseEntity.ok(productService.updateProduct(id, request));
    }
}
