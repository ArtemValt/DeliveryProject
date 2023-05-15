package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.bdcourseenums.RoleEnum;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.AddressEntity;
import com.bdcourse.bdcourse.model.entitys.PaymentMethodsEntity;
import com.bdcourse.bdcourse.model.entitys.RegionEntity;
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
