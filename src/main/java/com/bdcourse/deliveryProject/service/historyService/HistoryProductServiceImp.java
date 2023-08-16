package com.bdcourse.deliveryProject.service.historyService;

import com.bdcourse.deliveryProject.jpa.HistoryProductJpa;
import com.bdcourse.deliveryProject.model.entitys.CourierEntity;
import com.bdcourse.deliveryProject.model.entitys.HistoryDeliveryEntity;
import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.entitys.UserEntity;
import com.bdcourse.deliveryProject.service.CourierService;
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
        historyProductJpa.save(historyUser);
    }
}
