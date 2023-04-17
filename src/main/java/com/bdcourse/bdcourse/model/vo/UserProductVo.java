package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.entitys.UserEntity;
import lombok.Data;

@Data
public class UserProductVo {
    private String id;
    private ProductVo productEntity;
    private UserEntity userEntity;
    private int count;

}
