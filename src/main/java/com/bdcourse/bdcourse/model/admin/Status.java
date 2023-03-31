package com.bdcourse.bdcourse.model.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ACTIVE("ACTIVE"),
    REJECTED("REJECTED");
    private final String status;

}
