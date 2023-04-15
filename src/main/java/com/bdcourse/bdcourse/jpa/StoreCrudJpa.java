package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.StoreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StoreCrudJpa extends CrudRepository<StoreEntity, UUID> {
}
