package org.top.productandordersjsonapiapplication.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> getAll(); // получить список всех заказов
    Optional<Order> getById(Integer id); // получить заказ по id
    Boolean delete(Integer id); // удалить заказ по id
    Optional<Order> add(Order order); // создать заказ

}
