package com.bdcourse.deliveryProject.model.vo;

import com.bdcourse.deliveryProject.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CourierVo {
    private String id;
    private Date startWorkDate;
    private Status status;
    private BigDecimal salary;
    private RegionVo regionEntity;
}