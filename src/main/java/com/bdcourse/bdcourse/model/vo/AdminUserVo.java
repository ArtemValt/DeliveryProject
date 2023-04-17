package com.bdcourse.bdcourse.model.vo;

import lombok.Data;

@Data
public class AdminUserVo {
    private final String id;
    private final String name;
    private final String surname;
    private final String countUsers;
    private final String kikUsers;
    private final String password;
    private final String email;
}
