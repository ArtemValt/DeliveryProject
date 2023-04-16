package com.bdcourse.bdcourse.service.userProductsService;

import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.UserProductEntity;

public interface UserProductService {
    UserProductEntity getProductUserEntity(ProductEntity product, String userId);
   void saveProductUser(UserProductEntity userProductEntity);
}
