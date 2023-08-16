package com.bdcourse.deliveryProject.service;

import com.bdcourse.deliveryProject.jpa.ProductUserRep;
import com.bdcourse.deliveryProject.model.entitys.UserProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductUserServiceImp implements ProductUserService {
    private final ProductUserRep productUserRep;

    @Override
    public void saveHistory(UserProductEntity userProductEntity) {
        productUserRep.save(userProductEntity);
    }
}
