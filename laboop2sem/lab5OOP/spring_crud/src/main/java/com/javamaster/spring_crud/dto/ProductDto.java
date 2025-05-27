package com.javamaster.spring_crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private String description;
}