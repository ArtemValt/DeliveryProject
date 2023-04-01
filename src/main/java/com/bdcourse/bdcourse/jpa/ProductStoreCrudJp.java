package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductStoreCrudJp extends CrudRepository<ElectronicEntity, UUID> {
}
