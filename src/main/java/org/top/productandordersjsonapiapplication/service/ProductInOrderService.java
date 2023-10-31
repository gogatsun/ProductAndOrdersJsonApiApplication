package org.top.productandordersjsonapiapplication.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Order;
import org.top.productandordersjsonapiapplication.entity.ProductInOrder;

@Service
public interface ProductInOrderService {

    void add(ProductInOrder productInOrder, Order order);
}
