package com.bdcourse.bdcourse.service.users.admin;

import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.jpa.AdminServiceJpa;
import com.bdcourse.bdcourse.jpa.ProductStoreCrudJp;
import com.bdcourse.bdcourse.jpa.StoreCrudJpa;
import com.bdcourse.bdcourse.model.admin.Status;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import com.bdcourse.bdcourse.model.stors.StoreEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import com.bdcourse.bdcourse.model.vo.UserVo;
import org.springframework.transaction.annotation.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminServiceJpa adminServiceJpaService;
    private final StoreCrudJpa storeCrudJpa;
    private final ProductStoreCrudJp productStoreCrudJp;
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
        return adminServiceJpaService.getAllUsers().stream().map(x -> new UserVo(x.getId(), x.getName(), x.getSurname(), x.getEmail(), x.getPassword(), x.getRubles())).toList();
    }

    @Override
    public void addNewStore() {
        StoreVo storeVo = new StoreVo(UUID.randomUUID().toString(), "firtstStore", "staraZagora", "tvs",Status.ACTIVE);
        var storeEntity = storeCrudJpa.save(getEntityStore(storeVo));
        ElectronicProductVo electronicProductVo = new ElectronicProductVo();
        electronicProductVo.setId(storeEntity.getId());
        electronicProductVo.setName("productName");
        electronicProductVo.setPrice(BigDecimal.valueOf(123));
        productStoreCrudJp.save(getProductEntity(electronicProductVo));
    }
    private  StoreEntity getEntityStore(StoreVo storeVo){
        return new StoreEntity(storeVo.getId(),storeVo.getName(),storeVo.getAddress(),storeVo.getSubjectProduct(),storeVo.getStatus());
    }
    private ElectronicEntity getProductEntity(ElectronicProductVo electronicProductVo){
        return new ElectronicEntity(electronicProductVo.getId(), electronicProductVo.getName(), electronicProductVo.getPrice(), electronicProductVo.getCount(),new StoreEntity(electronicProductVo.getId()));
    }
}
