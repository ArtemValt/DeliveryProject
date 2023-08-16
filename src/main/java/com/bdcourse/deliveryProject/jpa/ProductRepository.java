package com.bdcourse.deliveryProject.jpa;

import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,String> {

}
