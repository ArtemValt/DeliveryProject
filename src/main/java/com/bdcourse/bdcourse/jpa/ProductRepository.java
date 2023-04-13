package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ElectronicEntity,String> {

}
