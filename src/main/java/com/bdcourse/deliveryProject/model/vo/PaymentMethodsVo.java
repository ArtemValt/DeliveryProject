package com.bdcourse.deliveryProject.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentMethodsVo {
    private final String id;
    private final String cvv;
    private final String numCard;
    private final Date expireDate;
    private final BankVo bankEntity;
}
