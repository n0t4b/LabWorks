package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.OrderDto;
import com.javamaster.spring_crud.entity.Order;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.OrderRepository;
import com.javamaster.spring_crud.repository.UsersRepository;
import com.javamaster.spring_crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) throws ValidationException {
        validateOrderDto(orderDto);
        if (!usersRepository.existsById(orderDto.getUserId())) {
            throw new ValidationException("User with ID " + orderDto.getUserId() + " not found.");
        }
        if (!productRepository.existsById(orderDto.getProductId())) {
            throw new ValidationException("Product with ID " + orderDto.getProductId() + " not found.");
        }

        Order savedOrder = orderRepository.save(orderConverter.fromOrderDtoToOrder(orderDto));
        return orderConverter.fromOrderToOrderDto(savedOrder);
    }

    private void validateOrderDto(OrderDto orderDto) throws ValidationException {
        if (isNull(orderDto)) {
            throw new ValidationException("Object order is null");
        }
        if (isNull(orderDto.getUserId())) {
            throw new ValidationException("User ID is empty");
        }
        if (isNull(orderDto.getProductId())) {
            throw new ValidationException("Product ID is empty");
        }
        if (isNull(orderDto.getQuantity()) || orderDto.getQuantity() <= 0) {
            throw new ValidationException("Quantity must be positive");
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDto> findOrderByUserId(Integer userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(orderConverter::fromOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByProductId(Integer productId) {
        return orderRepository.findByProductId(productId)
                .stream()
                .map(orderConverter::fromOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findAllOrders(Sort sort) {
        return orderRepository.findAll(sort)
                .stream()
                .map(orderConverter::fromOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return orderConverter.fromOrderToOrderDto(order);
        }
        return null;
    }
}