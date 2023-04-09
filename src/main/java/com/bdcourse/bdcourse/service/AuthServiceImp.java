package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.admin.Status;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{
    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String registerUser(String email, String password, String name, String surname) {
        UserVo userVo = DataHelper.getUserVo(email, surname,name, null, password, Status.ACTIVE);
        UserEntity saveEntity = userRepository.save(DataHelper.getUserEntityFromUserVo(userVo));
        return saveEntity.getId();
    }

    @Override
    public String loginUser(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        var user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Пользователь не найден"));
        return jwtService.generateToken(user.getId(),user);
    }
}
