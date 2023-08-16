package com.bdcourse.deliveryProject.jpa;

import com.bdcourse.deliveryProject.model.entitys.UserProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductUserRep extends CrudRepository<UserProductEntity, String> {
    @Query("select u from UserProductEntity u where u.userEntity.id =:id and u.productEntity.id=:productId")
    UserProductEntity getUserProductsByUserId(@Param(value = "id") String userId, @Param(value = "productId") String productId);
}
