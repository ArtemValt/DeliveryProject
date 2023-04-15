package com.bdcourse.bdcourse.service.userProductsService;

import com.bdcourse.bdcourse.model.entitys.UserProductEntity;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;

public interface UserProductService {
    UserProductEntity getProductUserEntity(ProductEntity product, String userId);
}
