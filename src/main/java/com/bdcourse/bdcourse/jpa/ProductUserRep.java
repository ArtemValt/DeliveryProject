package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductUserRep extends CrudRepository<UserProducts,String> {
    @Query("select u from UserProducts u where u.userEntity.id =:id")
    UserProducts getUserProductsByUserId(@Param(value = "id")String userId);
}
