package com.bdcourse.bdcourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ACTIVE("ACTIVE"),
    REJECTED("REJECTED");
    private final String status;

}
