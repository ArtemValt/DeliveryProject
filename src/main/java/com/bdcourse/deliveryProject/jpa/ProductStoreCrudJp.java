package com.bdcourse.deliveryProject.jpa;

import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductStoreCrudJp extends CrudRepository<ProductEntity, UUID> {
}
