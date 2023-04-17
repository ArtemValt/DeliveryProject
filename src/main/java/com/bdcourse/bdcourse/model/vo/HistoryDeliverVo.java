package com.bdcourse.bdcourse.model.vo;

import lombok.*;

@Data
public class HistoryDeliverVo {
    private final String id;
    private final UserEntity userEntity;
    private final CourierEntity courierEntity;
    private final ProductVo entities;
}
