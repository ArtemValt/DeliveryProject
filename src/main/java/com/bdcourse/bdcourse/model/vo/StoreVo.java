package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.NameEntity;
import com.bdcourse.bdcourse.model.admin.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class StoreVo implements NameEntity {
private String id;
private final String name;
private final String address;
private final String subjectProduct;
private final Status status;
}

