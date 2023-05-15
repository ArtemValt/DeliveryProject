package com.bdcourse.bdcourse.service.users.user;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.vo.ProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;

import java.util.List;

public interface UserService {
    void buyProduct(ProductVo electronicProductVo);
    void resetProduct(ProductVo electronicProductVo);
    PartOfList<StoreVo> getProductsFromCurrentStore(StoreVo storeVo);
    List<ProductVo> getProductsUser(String userId);
    List<StoreVo> getStores(String name,String address);


}
