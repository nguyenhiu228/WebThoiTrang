package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.service.FileStorageService;
import com.example.WebThoiTrang.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final Path rootLocation = Paths.get("uploads");

    public FileStorageServiceImpl() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Không thể tạo thư mục lưu trữ", e);
        }
    }

    public String storeFile(MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(fileName);
            Files.copy(file.getInputStream(), destinationFile);
            return "/uploads/" + fileName; // đường dẫn để hiển thị ảnh
        } catch (IOException e) {
            throw new RuntimeException("Không thể lưu file", e);
        }
    }
}
