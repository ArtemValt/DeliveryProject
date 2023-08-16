package com.bdcourse.deliveryProject.jpa;

import com.bdcourse.deliveryProject.model.entitys.StoreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StoreCrudJpa extends CrudRepository<StoreEntity, UUID> {
}
