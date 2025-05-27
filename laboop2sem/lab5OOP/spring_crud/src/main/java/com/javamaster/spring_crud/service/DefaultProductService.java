package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.ProductDto;
import com.javamaster.spring_crud.entity.Product;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDto saveProduct(ProductDto productDto) throws ValidationException {
        validateProductDto(productDto);
        Product savedProduct = productRepository.save(productConverter.fromProductDtoToProduct(productDto));
        return productConverter.fromProductToProductDto(savedProduct);
    }

    private void validateProductDto(ProductDto productDto) throws ValidationException {
        if (isNull(productDto)) {
            throw new ValidationException("Object product is null");
        }
        if (isNull(productDto.getName()) || productDto.getName().isEmpty()) {
            throw new ValidationException("Product name is empty");
        }
        if (isNull(productDto.getPrice())) {
            throw new ValidationException("Product price is empty");
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> findProductByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productConverter::fromProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findProductByDescription(String description) {
        return productRepository.findByDescriptionContainingIgnoreCase(description)
                .stream()
                .map(productConverter::fromProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProducts(Sort sort) {
        return productRepository.findAll(sort)
                .stream()
                .map(productConverter::fromProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return productConverter.fromProductToProductDto(product);
        }
        return null;
    }
}