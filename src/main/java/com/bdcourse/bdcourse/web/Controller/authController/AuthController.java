package com.bdcourse.bdcourse.web.Controller.authController;

import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.service.AuthService;
import com.bdcourse.bdcourse.web.Controller.ExceptionController;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController extends ExceptionController {
    private final AuthService authService;


    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestParam(value = "email") String email,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "surname", required = false) String surname) {
        if (!AppHelper.checkEmail(email))
            return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.BAD_REQUEST, null);
        String jwtToken = authService.registerUser(email, password, name, surname);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, jwtToken);
    }

    @PostMapping(value = "/login")
    public ResponseEntity register(@RequestParam(value = "email") String email,
                                   @RequestParam(value = "password") String password) {
        String jwtToken = authService.loginUser(email, password);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, jwtToken);
    }

    @PostMapping(value = "/registerPaypal")
    public ResponseEntity register(@RequestParam(value = "sum") BigDecimal sum,
                                   @RequestParam(value = "cvv") String cvv,
                                   @DateTimeFormat
                                   @RequestParam(value = "date") Date date,
                                   @RequestParam(value = "numCurd") String numCurd) {
        String paypalId = authService.registerPaypal(SecurityHelper.getUserId(), sum, cvv, date, numCurd);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, paypalId);
    }
}

