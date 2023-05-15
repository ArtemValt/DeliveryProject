package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.vo.ProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;

import java.util.Optional;

public interface UserServicesDto {
    PartOfList<StoreVo> getStores(String name, String address);
    Optional<ProductEntity> getProduct(ProductVo electronicProductVo,String userId);
    PartOfList<ProductVo> getUsersProductsByUserId(String userId);
    PartOfList<ProductEntity> getProductFromCurrentStore(StoreVo storeVo);

}
