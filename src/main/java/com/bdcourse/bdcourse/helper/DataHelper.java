package com.bdcourse.bdcourse.helper;


import com.bdcourse.bdcourse.bdcourseenums.RoleEnum;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataHelper {
    private static PasswordEncoder passwordEncoder;

    @Autowired(required = true)
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        DataHelper.passwordEncoder = passwordEncoder;
    }

    public static UserVo getUserVo(String email, String surname, String name, BigDecimal rubles, String password, Status status, List<ElectronicProductVo> productVos) {
        return UserVo.builder()
                .email(email)
                .surname(surname)
                .name(name)
                .rubles(rubles)
                .password(passwordEncoder.encode(password))
                .status(status)
                .roleEnum(RoleEnum.USER)
//                .productVoList(productVos)
                .build();
    }

    public static UserVo getUserVo(UserEntity userEntity) {
        return UserVo.builder().id(userEntity.getId())
                .email(userEntity.getEmail())
                .surname(userEntity.getSurname())
                .name(userEntity.getName())
//                .rubles(userEntity.getRubles())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .roleEnum(RoleEnum.USER).build();
    }

    public static UserEntity getUserEntityFromUserVo(UserVo userVo) {
        return new UserEntity(userVo.getId(), userVo.getName(),
                userVo.getSurname(),
                userVo.getPassword(), userVo.getEmail(),
                userVo.getStatus(), userVo.getRoleEnum(), userVo.getRegionEntity(), null, null);
//                .map(DataHelper::getElectronicEntityFromVo)
//                .collect(Collectors.toList()));
    }

    public static ProductEntity getElectronicEntityFromVo(ElectronicProductVo electronicProductVo) {
        return new ProductEntity(electronicProductVo.getId(), electronicProductVo.getName(),
                electronicProductVo.getPrice(), electronicProductVo.getCount(), null);
    }

    public static ElectronicProductVo getElectronicVoFromEntity(ProductEntity entity) {
        return new ElectronicProductVo().builder()
                .count(entity.getCountProducts())
                .id(entity.getId())
                .price(entity.getPrice())
                .name(entity.getProductName())
                .build();
    }
//    public static StoreEntity getStoreEntityFromVo(StoreVo storeVo) {
//        return new StoreEntity(storeVo.getId(), storeVo.getAddress(), storeVo.getSubjectProduct(), storeVo.getName(), storeVo.getStatus(), storeVo.getProductVos().stream().map(DataHelper::getElectronicEntityFromVo).toList());
//    }
}
