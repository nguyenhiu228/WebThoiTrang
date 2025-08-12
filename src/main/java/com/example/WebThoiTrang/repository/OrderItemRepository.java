package com.example.WebThoiTrang.repository;

import com.example.WebThoiTrang.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<Order_Item, Integer>{
    // Tìm tất cả OrderItem theo orderId
    List<Order_Item> findByOrderId(Integer orderId);
}
