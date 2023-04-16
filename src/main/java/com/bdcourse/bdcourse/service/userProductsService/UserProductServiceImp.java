package com.bdcourse.bdcourse.service.userProductsService;

import com.bdcourse.bdcourse.jpa.ProductUserRep;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.UserProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UserProductServiceImp implements UserProductService {
    private final ProductUserRep productUserRep;

    @Override
    public UserProductEntity getProductUserEntity(ProductEntity product, String userId) {
        UserProductEntity userProductEntity = productUserRep.getUserProductsByUserId(userId,product.getId());
        if (Objects.isNull(userProductEntity)) userProductEntity = new UserProductEntity();
        userProductEntity.setProductEntity(product);
        userProductEntity.setCount(userProductEntity.getCount() + 1);
        return productUserRep.save(userProductEntity);
    }

    @Override
    public void saveProductUser(UserProductEntity userProductEntity) {
        productUserRep.save(userProductEntity);
    }
}
