package com.bdcourse.bdcourse.web.Controller.authController;

import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.service.users.user.UserService;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestParam(value = "email")String email,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "name",required = false)String name,
                                   @RequestParam(value = "surname",required = false)String surname){
        String jwtToken = userService.registerUser(email, password);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK,jwtToken);
    }
}
