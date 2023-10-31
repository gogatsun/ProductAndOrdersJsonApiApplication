package org.top.productandordersjsonapiapplication.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "order_t")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_f", nullable = false)
    private String client;

    @Column(name = "created_at_f", nullable = false, updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private List<ProductInOrder> productInOrders;

    public Order() {
        id = null;
        client = null;
        createdAt = LocalDateTime.now();
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
