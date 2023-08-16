package com.bdcourse.deliveryProject.web.Controller;

import com.bdcourse.deliveryProject.bdcourseenums.ResponseEnum;
import com.bdcourse.deliveryProject.web.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException(RuntimeException e) {
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.FORBIDDEN, e.getMessage());
    }
}
