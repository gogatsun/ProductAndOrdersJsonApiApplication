package org.top.productandordersjsonapiapplication.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Order;
import org.top.productandordersjsonapiapplication.rdb.repositories.OrderRepositories;
import org.top.productandordersjsonapiapplication.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {

    private final OrderRepositories orderRepositories;

    public RdbOrderService(OrderRepositories orderRepositories) {
        this.orderRepositories = orderRepositories;
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepositories.findAll();
    }

    @Override
    public Optional<Order> getById(Integer id) {
        return orderRepositories.findById(id);
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Order> deleted = orderRepositories.findById(id);
        if (deleted.isPresent()) {
            orderRepositories.deleteById(id);
        }
        return deleted.isPresent();
    }

    @Override
    public Optional<Order> add(Order order) {
        return Optional.of(orderRepositories.save(order));
    }

}
