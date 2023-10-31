package org.top.productandordersjsonapiapplication.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productandordersjsonapiapplication.entity.Order;
import org.top.productandordersjsonapiapplication.entity.Product;
import org.top.productandordersjsonapiapplication.entity.ProductInOrder;
import org.top.productandordersjsonapiapplication.rdb.repositories.ProductInOrderRepositories;
import org.top.productandordersjsonapiapplication.rdb.repositories.ProductRepositories;
import org.top.productandordersjsonapiapplication.service.ProductInOrderService;

import java.util.Optional;

@Service
public class RdbProductInOrderService implements ProductInOrderService {

    private final ProductInOrderRepositories productInOrderRepositories;
    private final ProductRepositories productRepositories;


    public RdbProductInOrderService(ProductInOrderRepositories productInOrderRepositories,
                                    ProductRepositories productRepositories) {
        this.productInOrderRepositories = productInOrderRepositories;
        this.productRepositories = productRepositories;
    }


    @Override
    public void add(ProductInOrder productInOrder, Order order) {
        Optional<Product> product = productRepositories.findById(productInOrder.getProduct().getId());
        if (product.isEmpty()) {
            return;
        }
        if (productInOrder.getQuantity() <= product.get().getQuantity()) {
            Integer quantityProduct = product.get().getQuantity();
            product.get().setQuantity(quantityProduct - productInOrder.getQuantity());
            productRepositories.save(product.get());
        }
        productInOrder.setProduct(product.get());
        productInOrder.setOrder(order);
        productInOrderRepositories.save(productInOrder);
    }
}
