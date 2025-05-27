package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.ProductDto;
import com.javamaster.spring_crud.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product fromProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public ProductDto fromProductToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}