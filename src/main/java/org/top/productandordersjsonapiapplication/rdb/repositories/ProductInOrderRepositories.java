package org.top.productandordersjsonapiapplication.rdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productandordersjsonapiapplication.entity.ProductInOrder;

@Repository
public interface ProductInOrderRepositories extends CrudRepository<ProductInOrder, Integer> {
}
