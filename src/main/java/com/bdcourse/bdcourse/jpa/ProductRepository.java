package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,String> {

}
