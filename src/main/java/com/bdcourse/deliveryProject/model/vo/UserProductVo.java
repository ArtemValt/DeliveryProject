package com.bdcourse.deliveryProject.model.vo;

import com.bdcourse.deliveryProject.model.entitys.UserEntity;
import lombok.Data;

@Data
public class UserProductVo {
    private String id;
    private ProductVo productEntity;
    private UserEntity userEntity;
    private int count;

}
