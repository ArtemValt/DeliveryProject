package com.bdcourse.bdcourse.model.vo;

import lombok.*;

import java.math.BigDecimal;

@Data
public class ProductVo {
    private final String id;
    private final String productName;
    private  final BigDecimal price;
    private final int countProducts;
    private final DeterminationVo determinationEntity;
}
