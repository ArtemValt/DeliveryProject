package com.bdcourse.bdcourse.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionEntity {
    @Id
    @Column(name = "region_code", unique = true)
    private int regionCode;
    private String regionName;


}
