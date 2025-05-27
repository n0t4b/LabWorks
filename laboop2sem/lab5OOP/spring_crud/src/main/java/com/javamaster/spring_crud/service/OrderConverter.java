package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.OrderDto;
import com.javamaster.spring_crud.entity.Order;
import com.javamaster.spring_crud.repository.UsersRepository;
import com.javamaster.spring_crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class OrderConverter {

    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;

    public Order fromOrderDtoToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setQuantity(orderDto.getQuantity());
        order.setOrderDate(orderDto.getOrderDate() != null ? orderDto.getOrderDate() : LocalDateTime.now());

        // Находим Users и Product по ID из DTO
        usersRepository.findById(orderDto.getUserId()).ifPresent(order::setUser);
        productRepository.findById(orderDto.getProductId()).ifPresent(order::setProduct);

        return order;
    }

    public OrderDto fromOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUser() != null ? order.getUser().getId() : null)
                .productId(order.getProduct() != null ? order.getProduct().getId() : null)
                .quantity(order.getQuantity())
                .orderDate(order.getOrderDate())
                .build();
    }
}