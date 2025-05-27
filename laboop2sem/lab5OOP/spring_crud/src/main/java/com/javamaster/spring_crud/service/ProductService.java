package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.ProductDto;
import com.javamaster.spring_crud.exception.ValidationException;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto) throws ValidationException;
    void deleteProduct(Integer productId);
    List<ProductDto> findProductByName(String name);
    List<ProductDto> findProductByDescription(String description);
    List<ProductDto> findAllProducts(Sort sort);
    ProductDto findById(Integer id);
}