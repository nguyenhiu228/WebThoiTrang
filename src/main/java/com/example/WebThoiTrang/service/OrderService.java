package com.example.WebThoiTrang.service;

import com.example.WebThoiTrang.modelDTO.order.OrderDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderUpdateDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderRequestDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderDTO getOrderById(Integer orderId);

    List<OrderDTO> getOrdersByUserId(Integer userId);

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(Integer orderId, OrderUpdateDTO orderUpdateDTO);

    void deleteOrder(Integer orderId);
}
