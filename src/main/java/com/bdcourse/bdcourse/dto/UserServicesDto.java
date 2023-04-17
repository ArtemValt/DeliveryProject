package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;

import java.util.Optional;

public interface UserServicesDto {
    PartOfList<StoreVo> getStores(String name, String address);
    Optional<ProductEntity> getProduct(ElectronicProductVo electronicProductVo, String userId);
    PartOfList<ElectronicProductVo> getUsersProductsByUserId(String userId);
    PartOfList<ElectronicProductVo> getProductFromCurrentStore(StoreVo storeVo);

}
