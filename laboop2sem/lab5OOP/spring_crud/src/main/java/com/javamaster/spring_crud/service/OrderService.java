package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.OrderDto;
import com.javamaster.spring_crud.exception.ValidationException;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {
    OrderDto saveOrder(OrderDto orderDto) throws ValidationException;
    void deleteOrder(Integer orderId);
    List<OrderDto> findOrderByUserId(Integer userId);
    List<OrderDto> findOrderByProductId(Integer productId);
    List<OrderDto> findAllOrders(Sort sort);
    OrderDto findById(Integer id);
}