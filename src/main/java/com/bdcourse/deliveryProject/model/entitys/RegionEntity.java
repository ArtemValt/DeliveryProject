package com.bdcourse.deliveryProject.model.entitys;

import com.bdcourse.deliveryProject.jpa.abstractService.AbstractBaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegionEntity extends AbstractBaseEntity {
    private String regionCode;
    private String regionName;
}
