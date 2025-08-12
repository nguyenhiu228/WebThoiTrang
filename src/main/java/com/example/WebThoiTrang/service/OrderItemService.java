package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemCreateDTO;
import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemResponseDTO;
import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemUpdateDTO;

import org.hibernate.sql.Update;

import java.util.List;

public interface OrderItemService {
    // Create
    OrderItemResponseDTO createOrderItem(OrderItemCreateDTO orderItemCreateDTO);

    // Update
    OrderItemResponseDTO updateOrderItem(Integer id, OrderItemUpdateDTO orderItemUpdateDTO);

    // Delete
    void deleteOrderItem(Integer id);

    // Lấy tất cả OrderItem
    List<OrderItemResponseDTO> findAllOrderItems();

    // Lấy OrderItem theo Id
    OrderItemResponseDTO getOrderItemById(Integer id);

    // Lấy OrderItem theo OrderId
    List<OrderItemResponseDTO> getOrderItemsByOrderId(Integer orderId);
}
