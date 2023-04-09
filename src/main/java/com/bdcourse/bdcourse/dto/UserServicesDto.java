package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;

import java.util.List;

public interface UserServicesDto {
    List<StoreVo> getStores(String name,String address);
    void buyProduct(ElectronicProductVo electronicProductVo);
    ElectronicProductVo checkPrice(ElectronicProductVo electronicProductVo, String userId);
    PartOfList<ElectronicProductVo> getUsersProductsByUserId(String userId);
}
