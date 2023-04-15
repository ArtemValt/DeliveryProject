package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductStoreCrudJp extends CrudRepository<ProductEntity, UUID> {
}
