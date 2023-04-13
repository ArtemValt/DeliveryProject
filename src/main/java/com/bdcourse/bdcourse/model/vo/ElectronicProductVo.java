package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.NameEntity;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ElectronicProductVo implements NameEntity {
    private String id;
    private BigDecimal price;
    private int count;
    private String name;


}
