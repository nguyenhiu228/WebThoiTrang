package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.service.OrderService;
import org.springframework.stereotype.Service;
import com.example.WebThoiTrang.model.Order;
import com.example.WebThoiTrang.model.User;
import com.example.WebThoiTrang.repository.OrderRepository;
import com.example.WebThoiTrang.repository.UserRepository;
import com.example.WebThoiTrang.mapper.OrderMapper;
import com.example.WebThoiTrang.modelDTO.order.OrderDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderRequestDTO;
import com.example.WebThoiTrang.modelDTO.order.OrderUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        User user = userRepository.findById(orderRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Order order = OrderMapper.toEntity(orderRequestDTO, user);
        Order saved = orderRepository.save(order);
        return OrderMapper.toDTO(saved);
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUser_UserId(userId)
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(Integer orderId, OrderUpdateDTO orderUpdateDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        OrderMapper.updateEntity(order, orderUpdateDTO);
        Order updated = orderRepository.save(order);
        return OrderMapper.toDTO(updated);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }
}
