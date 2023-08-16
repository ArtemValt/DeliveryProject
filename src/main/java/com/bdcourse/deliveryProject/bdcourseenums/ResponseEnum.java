package com.bdcourse.deliveryProject.bdcourseenums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseEnum {
    GOOD("200","Operation success"),
    FAIL("FAIL","Operation fails");
    private final String status;
    private final String message;

}
