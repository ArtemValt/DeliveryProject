package com.bdcourse.bdcourse.service.users.user;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;

import java.util.List;

public interface UserService {
    void buyProduct(ElectronicProductVo electronicProductVo);
    void resetProduct(ElectronicProductVo electronicProductVo);
    List<StoreVo> getStores(String name, String address);
    PartOfList<StoreVo> getProductsFromCurrentStore(StoreVo storeVo);
    List<ElectronicProductVo> getProductsUser(String userId);


}
