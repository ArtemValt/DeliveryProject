package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.PaypalJpa;
import com.bdcourse.bdcourse.jpa.RegionJpa;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.PaymentMethodsEntity;
import com.bdcourse.bdcourse.model.entitys.RegionEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RegionJpa regionJpa;
    private final PaypalJpa paypalJpa;

    @Override
    public String registerUser(String email, String password, String name, String surname) {
        RegionEntity regionEntity;
        PaymentMethodsEntity paymentMethodsEntity = paypalJpa.save(new PaymentMethodsEntity(null, "111", "2123", new Date(), new BigDecimal(200), null));
        regionEntity = regionJpa.save(new RegionEntity(63, "Samara"));
        UserVo userVo = DataHelper.getUserVo(email, surname, name, password, Status.ACTIVE, Collections.emptyList());
        UserEntity userEntity = DataHelper.getUserEntityFromUserVo(userVo);
        userEntity.setRegionEntity(regionEntity);
        userEntity.setPaymentMethodsEntity(paymentMethodsEntity);
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()) throw new RuntimeException("Пользователь с таким email уже существует");
        UserEntity saveEntity = userRepository.save(userEntity);
        return saveEntity.getId();
    }

    @Override
    public String loginUser(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return jwtService.generateToken(user.getId(), user);
    }

    @Override
    public String registerPaypal(String userId, BigDecimal sum, String cvv, Date date, String numCurd) {
        Optional<UserEntity> user = userRepository.findById(SecurityHelper.getUserId());
        PaymentMethodsEntity paymentMethodsEntity = paypalJpa.save(new PaymentMethodsEntity());
        paymentMethodsEntity.setSum(sum);
        paymentMethodsEntity.setCvv(cvv);
        paymentMethodsEntity.setExpireDate(date);
        paymentMethodsEntity.setNumCard(numCurd);
        paypalJpa.save(paymentMethodsEntity);
        user.ifPresent(u -> {
            u.setPaymentMethodsEntity(paymentMethodsEntity);
            userRepository.save(u);
        });
        return paymentMethodsEntity.getId();
    }
}
