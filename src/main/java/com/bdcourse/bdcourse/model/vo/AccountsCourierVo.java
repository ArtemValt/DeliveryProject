package com.bdcourse.bdcourse.model.vo;

import lombok.*;

@Data
public class AccountsCourierVo {
    private final String id;
    private final CourierEntity courierEntity;
    private final BankVo bankEntity;
}
