package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.Status;
import lombok.Data;

import java.util.List;

@Data
public class StoreVo {
    private final String id;
    private final String address;
    private final String subjectProduct;
    private final String storeName;
    private final Status status;
    private final List<ProductVo> products;
    private final RegionVo regionEntity;


}
