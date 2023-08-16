package com.bdcourse.deliveryProject.jpa;

import com.bdcourse.deliveryProject.model.entitys.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionJpa extends JpaRepository<RegionEntity, String> {
}
