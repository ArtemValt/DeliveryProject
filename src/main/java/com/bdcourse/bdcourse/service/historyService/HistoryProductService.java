package com.bdcourse.bdcourse.service.historyService;

import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import com.bdcourse.bdcourse.model.entitys.UserEntity;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;

public interface HistoryProductService {
    void setProductHistory(UserEntity user, CourierEntity courier, ProductEntity productEntity);
}
