package com.bdcourse.bdcourse.service.users.user;


import com.bdcourse.bdcourse.dto.UserServicesDto;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.service.CourierService;
import com.bdcourse.bdcourse.service.historyService.HistoryProductService;
import com.bdcourse.bdcourse.service.productService.ProductServiceIml;
import com.bdcourse.bdcourse.service.userProductsService.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserServicesDto userServicesDto;
    private final UserRepository userRepository;
    private final ProductServiceIml productServiceIml;
    private final UserProductService userProductService;
    private final CourierService courierService;
    private final HistoryProductService historyProductService;


    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {
        final var userId = SecurityHelper.getUserId();
        final var product = productServiceIml.getProduct(electronicProductVo);
        final var userProductEntity = userProductService.getProductUserEntity(product, userId);
        final var user = userRepository.findById(userId);
        final var courier = courierService.findFreeCourier();
        historyProductService.setProductHistory(user.get(), courier, product);
//        updateUserStatus(user, product, userProductEntity);
        userProductService.saveProductUser(userProductEntity);
    }

    @Override
    public void resetProduct(ElectronicProductVo electronicProductVo) {

    }

//    @Override
//    public List<StoreVo> getStores(String name, String address) {
//        var stores = userServicesDto.getStores(name, address);
//        if (CollectionUtils.isEmpty(stores)) return Collections.emptyList();
//        return stores.stream()
//                .map(x -> new StoreVo(x.getId(), x.getName(), x.getAddress(), x.getSubjectProduct(), x.getStatus(), x.getProductVos(),x.getRegionEntity()))
//                .collect(Collectors.toList());
//    }

    @Override
    public PartOfList<StoreVo> getProductsFromCurrentStore(StoreVo storeVo) {
        return userServicesDto.getStores(storeVo.getName(), storeVo.getAddress());
    }

    @Override
    public List<ElectronicProductVo> getProductsUser(String userId) {
        return userServicesDto.getUsersProductsByUserId(userId).getList();
    }


//    private void updateUserStatus(Optional<UserEntity> user, ProductEntity product, UserProductEntity userProductEntity) {
//        if (user.isPresent()) {
//            final UserEntity userEntity = user.get();
//            userEntity.setRubles(userEntity.getRubles().subtract(product.getPrice()));
//            if (userEntity.getRubles().signum() == -1)
//                throw new RuntimeException("User dosn`t buy this product because dont have money");
//            userProductEntity.setUserEntity(userEntity);
//            userRepository.save(userEntity);
//        } else throw new RuntimeException(" User is not defline");
//    }


}