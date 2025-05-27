package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.ProductDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) throws ValidationException {
        log.info("Handling save product: " + productDto);
        return productService.saveProduct(productDto);
    }

    @GetMapping("/findAll")
    public List<ProductDto> findAllProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        log.info("Handling find all products request with sortBy: " + sortBy + ", sortDirection: " + sortDirection);
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        return productService.findAllProducts(sort);
    }

    @GetMapping("/findByName")
    public List<ProductDto> findProductByName(@RequestParam String name) {
        log.info("Handling find product by name request: " + name);
        return productService.findProductByName(name);
    }

    @GetMapping("/findByDescription")
    public List<ProductDto> findProductByDescription(@RequestParam String description) {
        log.info("Handling find product by description request: " + description);
        return productService.findProductByDescription(description);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        log.info("Handling delete product request: " + id);
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}