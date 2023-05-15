package com.bdcourse.bdcourse.service.users.admin;

import com.bdcourse.bdcourse.helper.DataHelper;
import com.bdcourse.bdcourse.jpa.ProductStoreCrudJp;
import com.bdcourse.bdcourse.jpa.RegionJpa;
import com.bdcourse.bdcourse.jpa.StoreCrudJpa;
import com.bdcourse.bdcourse.jpa.UserRepository;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.RegionEntity;
import com.bdcourse.bdcourse.model.entitys.StoreEntity;
import com.bdcourse.bdcourse.model.vo.ProductVo;
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

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository adminServiceJpaService;
    private final StoreCrudJpa storeCrudJpa;
    private final ProductStoreCrudJp productStoreCrudJp;
    private final RegionJpa regionJpa;


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

//    @Override
//    public StoreVo addNewStore() {
//        return null;
//    }

    @Override
    public StoreVo addNewStore() {
        RegionEntity region = regionJpa.save(new RegionEntity(63, "Samara"));
        StoreVo storeVo = new StoreVo(null, "firtstStore", "staraZagora", "tvs",
                Status.ACTIVE, List.of(ProductVo.builder().productName("1продукт").countProducts(1).price(new BigDecimal(100)).build()),
                new RegionEntity(region.getRegionCode(), region.getRegionName()));
        List<ProductEntity> entities = new ArrayList<>();
        storeVo.getProducts().forEach(x -> {
            ProductEntity productEntityFromVo = DataHelper.getElectronicEntityFromVo(x);
            entities.add(productStoreCrudJp.save(productEntityFromVo));
        });
        var storeEntity = getEntityStore(storeVo);
        storeEntity.setProducts(entities);
        storeCrudJpa.save(storeEntity);
        return storeVo;
    }

    private StoreEntity getEntityStore(StoreVo storeVo) {
        return new StoreEntity(storeVo.getId(), storeVo.getStoreName(), storeVo.getAddress(), storeVo.getSubjectProduct(), storeVo.getStatus(),
                storeVo.getProducts().stream().map(DataHelper::getElectronicEntityFromVo).toList(), storeVo.getRegionEntity());
    }

}
