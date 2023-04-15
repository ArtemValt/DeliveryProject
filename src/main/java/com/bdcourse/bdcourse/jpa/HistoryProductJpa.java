package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.HistoryDeliveryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HistoryProductJpa extends CrudRepository<HistoryDeliveryEntity, String> {
    @Query("select u from HistoryDeliveryEntity u where u.userEntity.id=:userId")
    HistoryDeliveryEntity getHistoryByUserId(@Param("userId") String userId);
}
