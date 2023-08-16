package com.bdcourse.deliveryProject.model.vo;

import com.bdcourse.deliveryProject.bdcourseenums.RoleEnum;
import com.bdcourse.deliveryProject.model.Status;
import com.bdcourse.deliveryProject.model.entitys.AddressEntity;
import com.bdcourse.deliveryProject.model.entitys.PaymentMethodsEntity;
import com.bdcourse.deliveryProject.model.entitys.RegionEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class UserVo {
    private final String id;
    private final String name;
    private final String surname;
    @NonNull
    private final String password;
    @NonNull
    private final String email;
    private final Status status;
    private final RoleEnum roleEnum;
    private final RegionEntity regionEntity;
    private final List<AddressEntity> addressEntities;
    private final PaymentMethodsEntity paymentMethodsVos;
}
