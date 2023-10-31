package org.top.productandordersjsonapiapplication.rdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productandordersjsonapiapplication.entity.Order;


@Repository
public interface OrderRepositories extends CrudRepository<Order, Integer> {

}
