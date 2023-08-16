package com.bdcourse.deliveryProject.model.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductVo {
    private String id;
    private String productName;
    private BigDecimal price;
    private int countProducts;
    private DeterminationVo determinationEntity;
}
