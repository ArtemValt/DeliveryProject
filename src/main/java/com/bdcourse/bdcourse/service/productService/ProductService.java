package com.bdcourse.bdcourse.service.productService;

import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.vo.ProductVo;

public interface  ProductService {
   ProductEntity getProduct(ProductVo electronicProductVo);
}
