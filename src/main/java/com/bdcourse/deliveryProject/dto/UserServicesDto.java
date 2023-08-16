package com.bdcourse.deliveryProject.dto;

import com.bdcourse.deliveryProject.model.PartOfList;
import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.vo.ProductVo;
import com.bdcourse.deliveryProject.model.vo.StoreVo;

import java.util.Optional;

public interface UserServicesDto {
    PartOfList<StoreVo> getStores(String name, String address);
    Optional<ProductEntity> getProduct(ProductVo electronicProductVo,String userId);
    PartOfList<ProductVo> getUsersProductsByUserId(String userId);
    PartOfList<ProductEntity> getProductFromCurrentStore(StoreVo storeVo);

}
