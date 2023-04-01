package com.bdcourse.bdcourse.service.users.user;


import com.bdcourse.bdcourse.dto.UserServicesDto;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserServicesDto userServicesDto;

    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {

        userServicesDto.checkPrice(electronicProductVo, StringUtils.EMPTY);
    }

    @Override
    public void resetProduct(ElectronicProductVo electronicProductVo) {

    }

    @Override
    public List<StoreVo> getStores(String name, String address) {
        List<StoreVo> stores = userServicesDto.getStores(name,address);
        if(CollectionUtils.isEmpty(stores)) return Collections.emptyList();
        return stores.stream()
                .map(x->new StoreVo(x.getId(),x.getName(),x.getAddress(),x.getSubjectProduct(),x.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public void getProductsFromCurrentStore(StoreVo storeVo) {

    }
}
