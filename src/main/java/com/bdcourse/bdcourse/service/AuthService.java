package com.bdcourse.bdcourse.service;

public interface AuthService {
    String registerUser(String email, String password, String name, String surname);

    String loginUser(String email, String password);
}
