package com.bdcourse.bdcourse.service.users.user;


import com.bdcourse.bdcourse.dto.UserServicesDto;
import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserServicesDto userServicesDto;
    private final UserRepository userRepository;
    private final DataHelper dataHelper;
    private final JwtService jwtService;

    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {

        userServicesDto.checkPrice(electronicProductVo, StringUtils.EMPTY);
    }

    @Override
    public void resetProduct(ElectronicProductVo electronicProductVo) {

    }

    @Override
    public List<StoreVo> getStores(String name, String address) {
        List<StoreVo> stores = userServicesDto.getStores(name, address);
        if (CollectionUtils.isEmpty(stores)) return Collections.emptyList();
        return stores.stream()
                .map(x -> new StoreVo(x.getId(), x.getName(), x.getAddress(), x.getSubjectProduct(), x.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public void getProductsFromCurrentStore(StoreVo storeVo) {

    }

    @Override
    public List<ElectronicProductVo> getProductsUser(String userId) {
        return userServicesDto.getUsersProductsByUserId(userId).getList();
    }

    @Override
    public String registerUser(String email, String password) {
        UserVo userVo = dataHelper.getUserVo(email, null,null, null, password, null);
        UserEntity saveEntity = userRepository.save(dataHelper.getUserEntityFromUserVo(userVo));
        String jwtToken = jwtService.generateToken(saveEntity.getId(),saveEntity);
        String s = SecurityHelper.getUserIdFromToken(jwtToken);
        return jwtToken;
    }
}