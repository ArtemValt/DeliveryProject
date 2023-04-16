package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.jpa.ProductUserRep;
import com.bdcourse.bdcourse.model.entitys.UserProductEntity;
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
