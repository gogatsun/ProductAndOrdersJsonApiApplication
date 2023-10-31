package org.top.productandordersjsonapiapplication.controller;

import org.springframework.web.bind.annotation.*;
import org.top.productandordersjsonapiapplication.entity.Order;
import org.top.productandordersjsonapiapplication.entity.ProductInOrder;
import org.top.productandordersjsonapiapplication.service.OrderService;
import org.top.productandordersjsonapiapplication.service.ProductInOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final ProductInOrderService productInOrderService;

    public OrderController(OrderService orderService,
                           ProductInOrderService productInOrderService) {
        this.orderService = orderService;
        this.productInOrderService = productInOrderService;
    }

    @GetMapping("")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Order> getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return orderService.delete(id);
    }

    @PostMapping("new")
    public Optional<Order> add(@RequestBody Order order) {
        Optional<Order> orderOptional = orderService.add(order);
        if (orderOptional.isEmpty()) {
            return Optional.empty();
        }
        for (ProductInOrder productInOrder : order.getProductInOrders()) {
            productInOrderService.add(productInOrder, orderOptional.get());
        }
        return orderService.getById(orderOptional.get().getId());
    }
}


/*
*
{
    "client": "C3",
    "productInOrders":
        [
            {
                "quantity": 3,
                "product": {
                    "id": 3
                }
            },
            {
                "quantity": 4,
                "product": {
                    "id": 4
                }
            }
        ]

}*/
