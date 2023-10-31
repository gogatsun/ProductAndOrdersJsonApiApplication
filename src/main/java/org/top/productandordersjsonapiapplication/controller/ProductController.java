package org.top.productandordersjsonapiapplication.controller;

import org.springframework.web.bind.annotation.*;
import org.top.productandordersjsonapiapplication.entity.Product;
import org.top.productandordersjsonapiapplication.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("new")
    public Optional<Product> addNew(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return productService.delete(id);
    }

    @PostMapping("update")
    public Optional<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Product> getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping("name")
    public Optional<Product> getByName(@RequestParam String name) {
        return productService.getByName(name);
    }
}
