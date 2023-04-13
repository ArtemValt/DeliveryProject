package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.NameEntity;
import com.bdcourse.bdcourse.model.entitys.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class StoreVo implements NameEntity {
    private String id;
    private String name;
    private String address;
    private String subjectProduct;
    private Status status;
    private List<ElectronicProductVo> productVos;
}

