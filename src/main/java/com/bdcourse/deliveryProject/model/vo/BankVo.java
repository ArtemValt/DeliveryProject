package com.bdcourse.deliveryProject.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class BankVo {
    private final String id;
    private final List<PaymentMethodsVo> paymentMethodsEntityList;
    final RegionVo regionEntity;
}
