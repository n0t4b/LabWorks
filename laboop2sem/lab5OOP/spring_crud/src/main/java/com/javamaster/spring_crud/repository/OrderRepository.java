package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);

    List<Order> findByProductId(Integer productId);

    List<Order> findAll(Sort sort);
}