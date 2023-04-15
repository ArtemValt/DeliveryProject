package com.bdcourse.bdcourse.service.users.admin;

import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.jpa.ProductStoreCrudJp;
import com.bdcourse.bdcourse.jpa.RegionJpa;
import com.bdcourse.bdcourse.jpa.StoreCrudJpa;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.RegionEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.StoreEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import com.bdcourse.bdcourse.model.vo.UserVo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository adminServiceJpaService;
    private final StoreCrudJpa storeCrudJpa;
    private final ProductStoreCrudJp productStoreCrudJp;
    private final RegionJpa regionJpa;

    @Override
    public boolean addUser(@NonNull UserVo user) throws Exception {
        if (!AppHelper.checkEmail(user.getEmail())) return false;
        UserEntity userEntity = adminServiceJpaService.checkUserByEmailAndName(user.getEmail(), user.getName());
        if (Objects.nonNull(userEntity)) throw new Exception("Пользователь не найден");
        return adminServiceJpaService.addNewUser(user.getId(), user.getName(), user.getSurname(),
                user.getRubles(), user.getPassword(), user.getEmail(), Status.ACTIVE.getStatus()) == 1;

    }

    @Override
    public boolean banUser(@NonNull UserVo user) {
        return BooleanUtils.toBoolean(adminServiceJpaService.banUser(Status.REJECTED.getStatus(), user.getEmail(), user.getName()));
    }

    @Override
    public boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate) {
        return false;
    }

    @Override
    public List<UserVo> getAllUsers() {
        return adminServiceJpaService.getAllUsers().stream()
                .map(DataHelper::getUserVo)
                .toList();
    }

    @Override
    public StoreVo addNewStore() {
        RegionEntity region = regionJpa.save(new RegionEntity(63,"Samara"));
        StoreVo storeVo = new StoreVo(null, "firtstStore", "staraZagora", "tvs",
                Status.ACTIVE, List.of(new ElectronicProductVo(null, new BigDecimal(100), 2, "продукт1"),
                new ElectronicProductVo(null, new BigDecimal(500), 3, "продукт2")), region);
        List<ProductEntity> entities = new ArrayList<>();
        storeVo.getProductVos().forEach(x -> {
            ProductEntity productEntityFromVo = DataHelper.getElectronicEntityFromVo(x);
            entities.add(productStoreCrudJp.save(productEntityFromVo));
        });
        var storeEntity = getEntityStore(storeVo);
        storeEntity.setProducts(entities);
        storeCrudJpa.save(storeEntity);
        return storeVo;
    }

    private StoreEntity getEntityStore(StoreVo storeVo) {
        return new StoreEntity(storeVo.getId(), storeVo.getName(), storeVo.getAddress(), storeVo.getSubjectProduct(), storeVo.getStatus(),
                storeVo.getProductVos().stream().map(DataHelper::getElectronicEntityFromVo).toList(), storeVo.getRegionEntity());
    }

}
