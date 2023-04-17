package com.bdcourse.bdcourse.model.vo;

import lombok.*;

import java.util.List;

@Data
public class BankVo {
    private final String id;
    private final List<PaymentMethodsVo> paymentMethodsEntityList;
    final RegionVo regionEntity;
}