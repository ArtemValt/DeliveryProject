package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.jpa.RegionJpa;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.Status;
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

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RegionJpa regionJpa;

    @Override
    public String registerUser(String email, String password, String name, String surname) {
        RegionEntity regionEntity = regionJpa.save(new RegionEntity(63, "Samara"));
        UserVo userVo = DataHelper.getUserVo(email, surname, name, new BigDecimal(200), password, Status.ACTIVE, Collections.emptyList());
        UserEntity userEntity = DataHelper.getUserEntityFromUserVo(userVo);
        userEntity.setRegionEntity(regionEntity);
        UserEntity saveEntity = userRepository.save(userEntity);
        return saveEntity.getId();
    }

    @Override
    public String loginUser(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        var user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return jwtService.generateToken(user.getId(), user);
    }
}
