package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface RegionJpa extends JpaRepository<RegionEntity,String> {
}
