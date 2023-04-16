package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.jpa.CourierJpa;
import com.bdcourse.bdcourse.model.Status;
import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class CourierServiceImp implements CourierService {
    private final CourierJpa courierJpa;

    @Override
    public CourierEntity findFreeCourier() {
        return Objects.nonNull(courierJpa.getFreeCourier()) ? courierJpa.getFreeCourier() : getNewEntity();
    }

    @Override
    public CourierEntity saveCourier(CourierEntity courier) {
        return courierJpa.save(courier);
    }

    private CourierEntity getNewEntity() {
        return new CourierEntity(null, new Date(), Status.ACTIVE, null, null);
    }
}
