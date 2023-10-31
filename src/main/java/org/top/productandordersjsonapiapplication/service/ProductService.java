package org.top.productandordersjsonapiapplication.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Optional<Product> add(Product product); // добавить товар
    Boolean delete(Integer id); // удалить товар
    Optional<Product> update(Product product); // редактировать товар
    List<Product> getAll(); // получить список товаров
    Optional<Product> getById(Integer id); // получить товар по id
    Optional<Product> getByName(String name); // получить товар по названию

}
