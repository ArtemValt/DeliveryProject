package com.bdcourse.deliveryProject.service.users.user;


import com.bdcourse.deliveryProject.dto.UserServicesDto;
import com.bdcourse.deliveryProject.helper.SecurityHelper;
import com.bdcourse.deliveryProject.jpa.PaypalJpa;
import com.bdcourse.deliveryProject.jpa.UserRepository;
import com.bdcourse.deliveryProject.model.PartOfList;
import com.bdcourse.deliveryProject.model.entitys.PaymentMethodsEntity;
import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.entitys.UserEntity;
import com.bdcourse.deliveryProject.model.entitys.UserProductEntity;
import com.bdcourse.deliveryProject.model.vo.ProductVo;
import com.bdcourse.deliveryProject.model.vo.StoreVo;
import com.bdcourse.deliveryProject.service.CourierService;
import com.bdcourse.deliveryProject.service.historyService.HistoryProductService;
import com.bdcourse.deliveryProject.service.productService.ProductServiceIml;
import com.bdcourse.deliveryProject.service.userProductsService.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    private final PaypalJpa paypalJpa;


    @Override
    public void buyProduct(ProductVo electronicProductVo) {
        final var userId = SecurityHelper.getUserId();
        final var product = productServiceIml.getProduct(electronicProductVo);
        final var userProductEntity = userProductService.getProductUserEntity(product, userId);
        final var user = userRepository.findById(userId);
        final var courier = courierService.findFreeCourier();
        historyProductService.setProductHistory(user.get(), courier, product);
        updateUserStatus(user, product, userProductEntity);
        userProductService.saveProductUser(userProductEntity);
    }

    @Override
    public void resetProduct(ProductVo electronicProductVo) {

    }


    @Override
    public PartOfList<StoreVo> getProductsFromCurrentStore(StoreVo storeVo) {
        return userServicesDto.getStores(storeVo.getStoreName(), storeVo.getAddress());
    }

    @Override
    public List<ProductVo> getProductsUser(String userId) {
        return userServicesDto.getUsersProductsByUserId(userId).getList();
    }

    @Override
    public List<StoreVo> getStores(String name, String address) {
        return userServicesDto.getStores(name, address).getList();
    }


    private void updateUserStatus(Optional<UserEntity> user, ProductEntity product, UserProductEntity userProductEntity) {
        if (user.isPresent()) {
            final UserEntity userEntity = user.get();
            PaymentMethodsEntity paymentMethodsEntity = userEntity.getPaymentMethodsEntity();
            BigDecimal subtract = paymentMethodsEntity.getSum().subtract(product.getPrice());
            if (subtract.intValue() < 0) throw new RuntimeException("Недостаточно средств");
            paymentMethodsEntity.setSum(subtract);
            paymentMethodsEntity = paypalJpa.save(paymentMethodsEntity);
            userProductEntity.setUserEntity(userEntity);
            userEntity.setPaymentMethodsEntity(paymentMethodsEntity);
            userRepository.save(userEntity);
        } else throw new RuntimeException(" User is not defline");
    }


}