package com.bdcourse.deliveryProject.service.userProductsService;

import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.entitys.UserProductEntity;

public interface UserProductService {
    UserProductEntity getProductUserEntity(ProductEntity product, String userId);
   void saveProductUser(UserProductEntity userProductEntity);
}
