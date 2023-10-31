package org.top.productandordersjsonapiapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product_t")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", nullable = false, unique = true)
    private String name;

    @Column(name = "price_f", nullable = false)
    private Double price;

    @Column(name = "quantity_f", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductInOrder> productInOrders;

    public Set<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(Set<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public Product() {
        id = null;
        name = null;
        price = null;
        quantity = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
