package com.bdcourse.deliveryProject.helper;


import com.bdcourse.deliveryProject.bdcourseenums.RoleEnum;
import com.bdcourse.deliveryProject.model.Status;
import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.entitys.UserEntity;
import com.bdcourse.deliveryProject.model.vo.ProductVo;
import com.bdcourse.deliveryProject.model.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataHelper {
    private static PasswordEncoder passwordEncoder;

    @Autowired(required = true)
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        DataHelper.passwordEncoder = passwordEncoder;
    }

    public static UserVo getUserVo(String email, String surname, String name, String password, Status status, List<ProductVo> productVos) {
        return UserVo.builder()
                .email(email)
                .surname(surname)
                .name(name)
                .password(passwordEncoder.encode(password))
                .status(status)
                .roleEnum(RoleEnum.USER)
                .build();
    }

    public static UserVo getUserVo(UserEntity userEntity) {
        return UserVo.builder().id(userEntity.getId())
                .email(userEntity.getEmail())
                .surname(userEntity.getSurname())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .roleEnum(RoleEnum.USER).build();
    }

    public static UserEntity getUserEntityFromUserVo(UserVo userVo) {
        return new UserEntity(userVo.getId(), userVo.getName(), userVo.getSurname(), userVo.getPassword(), userVo.getEmail(), userVo.getStatus(),
                userVo.getRoleEnum(), userVo.getRegionEntity(), userVo.getAddressEntities(), userVo.getPaymentMethodsVos());
    }

    public static ProductEntity getElectronicEntityFromVo(ProductVo electronicProductVo) {
        return new ProductEntity(electronicProductVo.getId(), electronicProductVo.getProductName(),
                electronicProductVo.getPrice(), electronicProductVo.getCountProducts(), null);
    }

    public static ProductVo getElectronicVoFromEntity(ProductEntity entity) {
        return ProductVo.builder()
                .countProducts(entity.getCountProducts())
                .id(entity.getId())
                .price(entity.getPrice())
                .productName(entity.getProductName())
                .build();
    }
//    public static StoreEntity getStoreEntityFromVo(StoreVo storeVo) {
//        return new StoreEntity(storeVo.getId(), storeVo.getAddress(), storeVo.getSubjectProduct(), storeVo.getName(), storeVo.getStatus(), storeVo.getProductVos().stream().map(DataHelper::getElectronicEntityFromVo).toList());
//    }
}
