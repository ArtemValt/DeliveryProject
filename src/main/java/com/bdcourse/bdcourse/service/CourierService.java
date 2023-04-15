package com.bdcourse.bdcourse.service;

import com.bdcourse.bdcourse.model.entitys.CourierEntity;

public interface CourierService {
   CourierEntity findFreeCourier();
   CourierEntity saveCourier(CourierEntity courier);
}
