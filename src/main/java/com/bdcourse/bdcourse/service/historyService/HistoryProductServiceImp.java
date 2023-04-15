package com.bdcourse.bdcourse.service.historyService;

import com.bdcourse.bdcourse.jpa.HistoryProductJpa;
import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import com.bdcourse.bdcourse.model.entitys.HistoryDeliveryEntity;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import com.bdcourse.bdcourse.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class HistoryProductServiceImp implements HistoryProductService {
    private final HistoryProductJpa historyProductJpa;
    private final CourierService courierService;

    @Override
    public void setProductHistory(UserEntity user, CourierEntity courier, ProductEntity productEntity) {
        HistoryDeliveryEntity historyUser = new HistoryDeliveryEntity();
        if (Objects.nonNull(courier)) {
            courier.setSalary(productEntity.getPrice().divide(new BigDecimal(10)));
            courierService.saveCourier(courier);
            historyUser.setCourierEntity(courier);
        }
        historyUser.setEntities(productEntity);
        historyUser.setUserEntity(user);
        HistoryDeliveryEntity history = historyProductJpa.save(historyUser);
    }
}
