package org.top.productandordersjsonapiapplication.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Product;
import org.top.productandordersjsonapiapplication.rdb.repositories.ProductRepositories;
import org.top.productandordersjsonapiapplication.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbProductService implements ProductService {

    private final ProductRepositories productRepositories;

    public RdbProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }


    // добавить товар
    @Override
    public Optional<Product> add(Product product) {
        Optional<Product> existing = productRepositories.findByName(product.getName());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(productRepositories.save(product));
    }

    // удалить товар
    @Override
    public Boolean delete(Integer id) {
        Optional<Product> deleted = productRepositories.findById(id);
        if (deleted.isPresent()) {
            productRepositories.deleteById(id);
        }
        return deleted.isPresent();
    }

    // редактировать товар
    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> updated = productRepositories.findById(product.getId());
        // товара с таким id нет в базе
        if (updated.isEmpty()) {
            return Optional.empty();
        }
        Optional<Product> existing = productRepositories.findByName(product.getName());
        // товар с таким названием есть в базе
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(productRepositories.save(product));

    }


    // получить список товаров
    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepositories.findAll();
    }


    // получить товар по id
    @Override
    public Optional<Product> getById(Integer id) {
        return productRepositories.findById(id);
    }


    // получить товар по названию
    @Override
    public Optional<Product> getByName(String name) {
        return productRepositories.findByName(name);
    }
}
