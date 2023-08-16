package com.bdcourse.deliveryProject.service;

import java.math.BigDecimal;
import java.util.Date;

public interface AuthService {
    String registerUser(String email, String password, String name, String surname);

    String loginUser(String email, String password);

    String registerPaypal(String userId, BigDecimal sum, String cvv, Date date, String numCurd);
}
