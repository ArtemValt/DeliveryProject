package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.Status;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private final String id;
    private final String name;
    private final String surname;
    private final String password;
    private final String email;
    private final Status status;
    private final RegionVo regionEntity;
    private final List<AddressVo> addressEntities;
}
