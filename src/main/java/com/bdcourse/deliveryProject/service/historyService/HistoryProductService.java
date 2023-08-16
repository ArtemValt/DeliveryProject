package com.bdcourse.deliveryProject.service.historyService;

import com.bdcourse.deliveryProject.model.entitys.CourierEntity;
import com.bdcourse.deliveryProject.model.entitys.ProductEntity;
import com.bdcourse.deliveryProject.model.entitys.UserEntity;

public interface HistoryProductService {
    void setProductHistory(UserEntity user, CourierEntity courier, ProductEntity productEntity);
}
