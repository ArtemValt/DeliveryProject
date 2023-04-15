package com.bdcourse.bdcourse.service.productService;

import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;

public interface  ProductService {
   ProductEntity getProduct(ElectronicProductVo electronicProductVo);
}
