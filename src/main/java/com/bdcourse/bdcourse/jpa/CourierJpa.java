package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourierJpa extends JpaRepository<CourierEntity, String> {
    @Query("select c from CourierEntity c where c.salary " +
            "in(select min(c.salary) from CourierEntity  c ) and c.status<>'REJECTED'")
    CourierEntity getFreeCourier();
}
