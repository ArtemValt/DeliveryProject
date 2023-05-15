package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.entitys.PaymentMethodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaypalJpa extends JpaRepository<PaymentMethodsEntity, String> {
    @Query("select u.paymentMethodsEntity from UserEntity u where u.id =:id")
    PaymentMethodsEntity getPaymentMethodsEntitiesByUserId(@Param("id")String id);
}
