package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.entitys.CourierEntity;
import lombok.Data;

@Data
public class HistoryDeliverVo {
    private final String id;
    private final UserVo userEntity;
    private final CourierEntity courierEntity;
    private final ProductVo entities;
}
