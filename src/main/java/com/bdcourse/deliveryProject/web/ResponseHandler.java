package com.bdcourse.deliveryProject.web;

import com.bdcourse.deliveryProject.bdcourseenums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(ResponseEnum message, HttpStatus status, Object responseObj) {
        Map<String, Object> responseMap =
                Map.of("message", message.getMessage(), "status", status.value(), "data", responseObj);
        return new ResponseEntity<>(responseMap, status);
    }

}
