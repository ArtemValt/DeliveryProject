package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.NameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ElectronicProductVo implements NameEntity {
    private String id;
    private BigDecimal price;
    private int count;
    private String name;
    private String store;

}
