package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import lombok.Data;

@Data
public class AccountsCourierVo {
    private final String id;
    private final CourierEntity courierEntity;
    private final BankVo bankEntity;
}
