package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemCreateDTO;
import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemResponseDTO;
import com.example.WebThoiTrang.modelDTO.OrderItem.OrderItemUpdateDTO;
import com.example.WebThoiTrang.repository.OrderItemRepository;
import com.example.WebThoiTrang.repository.ProductRepository;
import com.example.WebThoiTrang.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    /*@Autowired
    private OrderRepository orderRepository;*/

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItemResponseDTO createOrderItem(OrderItemCreateDTO orderItemCreateDTO) {
        return null;
    }

    @Override
    public OrderItemResponseDTO updateOrderItem(Integer id, OrderItemUpdateDTO orderItemUpdateDTO) {
        return null;
    }

    @Override
    public void deleteOrderItem(Integer id) {

    }

    @Override
    public List<OrderItemResponseDTO> findAllOrderItems() {
        return List.of();
    }

    @Override
    public OrderItemResponseDTO getOrderItemById(Integer id) {
        return null;
    }

    @Override
    public List<OrderItemResponseDTO> getOrderItemsByOrderId(Integer orderId) {
        return List.of();
    }
}
