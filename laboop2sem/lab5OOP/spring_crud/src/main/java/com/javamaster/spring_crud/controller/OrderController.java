package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.OrderDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Log
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) throws ValidationException {
        log.info("Handling save order: " + orderDto);
        return orderService.saveOrder(orderDto);
    }

    @GetMapping("/findAll")
    public List<OrderDto> findAllOrders(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        log.info("Handling find all orders request with sortBy: " + sortBy + ", sortDirection: " + sortDirection);
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        return orderService.findAllOrders(sort);
    }

    @GetMapping("/findByUserId")
    public List<OrderDto> findOrderByUserId(@RequestParam Integer userId) {
        log.info("Handling find order by user ID request: " + userId);
        return orderService.findOrderByUserId(userId);
    }

    @GetMapping("/findByProductId")
    public List<OrderDto> findOrderByProductId(@RequestParam Integer productId) {
        log.info("Handling find order by product ID request: " + productId);
        return orderService.findOrderByProductId(productId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        log.info("Handling delete order request: " + id);
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}