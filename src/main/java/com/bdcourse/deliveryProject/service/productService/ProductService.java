package com.bdcourse.deliveryProject.service.productService;

import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.vo.ProductVo;

public interface  ProductService {
   ProductEntity getProduct(ProductVo electronicProductVo);
}
