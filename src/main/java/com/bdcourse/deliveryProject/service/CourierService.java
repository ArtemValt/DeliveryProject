package com.bdcourse.deliveryProject.service;

import com.bdcourse.deliveryProject.model.entitys.CourierEntity;

public interface CourierService {
   CourierEntity findFreeCourier();
   CourierEntity saveCourier(CourierEntity courier);
}
