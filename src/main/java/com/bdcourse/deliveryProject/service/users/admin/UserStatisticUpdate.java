package com.bdcourse.deliveryProject.service.users.admin;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class UserStatisticUpdate {
    private final BigDecimal updateCheck;
    private final String name;
    private final String surname;
    private final String email;
}
