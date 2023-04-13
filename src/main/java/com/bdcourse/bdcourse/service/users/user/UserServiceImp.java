package com.bdcourse.bdcourse.service.users.user;


import com.bdcourse.bdcourse.dto.UserServicesDto;
import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.ProductRepository;
import com.bdcourse.bdcourse.jpa.ProductUserRep;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import com.bdcourse.bdcourse.model.entitys.UserProducts;
import com.bdcourse.bdcourse.model.stors.StoreEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserServicesDto userServicesDto;
    private final UserRepository userRepository;
    private final ProductUserRep productUserRep;
    private final ProductRepository productRepository;


    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {
        final String userId = SecurityHelper.getUserId();
        var product = userServicesDto.getProduct(electronicProductVo, userId);
        product.setCountProducts(product.getCountProducts() - 1);
        productRepository.save(product);
        UserProducts userProducts = productUserRep.getUserProductsByUserId(userId);
        if (Objects.isNull(userProducts)) userProducts = new UserProducts();
        userProducts.setElectronicEntity(product);
        userProducts.setCount(userProducts.getCount() + 1);
        var user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            userEntity.setRubles(userEntity.getRubles().subtract(product.getPrice()));
            if (userEntity.getRubles().signum() == -1) throw new RuntimeException();
            userProducts.setUserEntity(userEntity);
            userRepository.save(userEntity);
        } else throw new RuntimeException(" User is not defline");
        productUserRep.save(userProducts);
    }

    @Override
    public void resetProduct(ElectronicProductVo electronicProductVo) {

    }

    @Override
    public List<StoreVo> getStores(String name, String address) {
        var stores = userServicesDto.getStores(name, address);
        if (CollectionUtils.isEmpty(stores)) return Collections.emptyList();
        return stores.stream()
                .map(x -> new StoreVo(x.getId(), x.getName(), x.getAddress(), x.getSubjectProduct(), x.getStatus(), x.getProductVos()))
                .collect(Collectors.toList());
    }

    @Override
    public PartOfList<StoreVo> getProductsFromCurrentStore(StoreVo storeVo) {
        return userServicesDto.getStores(storeVo.getName(), storeVo.getAddress());
    }

    @Override
    public List<ElectronicProductVo> getProductsUser(String userId) {
        return userServicesDto.getUsersProductsByUserId(userId).getList();
    }

    private StoreEntity getStoreEntityFromVo(StoreVo storeVo) {
        return new StoreEntity(storeVo.getId(), storeVo.getAddress(), storeVo.getSubjectProduct(), storeVo.getName(), storeVo.getStatus(), storeVo.getProductVos().stream().map(DataHelper::getElectronicEntityFromVo).toList());
    }


}