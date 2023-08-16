package com.bdcourse.deliveryProject.jpa.abstractService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity> extends JpaRepository<T, String> {

}


