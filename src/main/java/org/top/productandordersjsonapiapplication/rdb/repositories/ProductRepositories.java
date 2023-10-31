package org.top.productandordersjsonapiapplication.rdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productandordersjsonapiapplication.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepositories extends CrudRepository<Product, Integer> {

    Optional<Product> findByName(String name);
}
