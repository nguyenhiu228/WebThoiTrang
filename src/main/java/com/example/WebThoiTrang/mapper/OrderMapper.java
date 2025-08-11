package com.example.WebThoiTrang.mapper;

import com.example.WebThoiTrang.model.Order;
import com.example.WebThoiTrang.model.User;
import com.example.WebThoiTrang.modelDTO.order.OrderDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderRequestDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderUpdateDTO;

import java.time.LocalDateTime;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        if (order == null) return null;

        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        if (order.getUser() != null) {
            dto.setUserId(order.getUser().getUserId());
            dto.setUsername(order.getUser().getUsername());
        }
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setCreatedAt(order.getCreatedAt());
        return dto;
    }

    public static Order toEntity(OrderRequestDTO dto, User user) {
        if (dto == null) return null;
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(dto.getTotalAmount());
        order.setStatus(dto.getStatus());
        order.setShippingAddress(dto.getShippingAddress());
        order.setCreatedAt(LocalDateTime.now());
        return order;
    }

    public static void updateEntity(Order order, OrderUpdateDTO dto) {
        if (dto == null || order == null) return;
        if (dto.getTotalAmount() != null) {
            order.setTotalAmount(dto.getTotalAmount());
        }
        if (dto.getStatus() != null) {
            order.setStatus(dto.getStatus());
        }
        if (dto.getShippingAddress() != null) {
            order.setShippingAddress(dto.getShippingAddress());
        }
    }
}
