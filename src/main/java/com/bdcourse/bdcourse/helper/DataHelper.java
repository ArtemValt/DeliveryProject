package com.bdcourse.bdcourse.helper;


import com.bdcourse.bdcourse.bdcourseenums.RoleEnum;
import com.bdcourse.bdcourse.model.admin.Status;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.model.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DataHelper {
    private final PasswordEncoder passwordEncoder;

    public UserVo getUserVo(String email, String surname, String name, BigDecimal rubles, String password, Status status) {
        return UserVo.builder()
                .email(email)
                .surname(surname)
                .name(name)
                .rubles(rubles)
                .password(passwordEncoder.encode(password))
                .status(status)
                .roleEnum(RoleEnum.USER)
                .build();
    }

    public UserVo getUserVo(UserEntity userEntity) {
        return UserVo.builder().id(userEntity.getId())
                .email(userEntity.getEmail())
                .surname(userEntity.getSurname())
                .name(userEntity.getName())
                .rubles(userEntity.getRubles())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .roleEnum(RoleEnum.USER).build();
    }

    public UserEntity getUserEntityFromUserVo(UserVo userVo) {
        return new UserEntity(userVo.getId(), userVo.getName(),
                userVo.getSurname(), userVo.getRubles(),
                userVo.getPassword(), userVo.getEmail(),
                userVo.getStatus(), userVo.getRoleEnum());
    }
}
