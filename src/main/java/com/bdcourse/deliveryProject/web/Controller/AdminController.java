package com.bdcourse.deliveryProject.web.Controller;

import com.bdcourse.deliveryProject.bdcourseenums.ResponseEnum;
import com.bdcourse.deliveryProject.model.vo.UserVo;
import com.bdcourse.deliveryProject.service.users.admin.AdminService;
import com.bdcourse.deliveryProject.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/service")
public class AdminController {
    private final AdminService adminService;



    @PutMapping(value = "/banUser")
    public ResponseEntity<Object> banUser(@ModelAttribute @Validated UserVo userVo) {
        boolean result = adminService.banUser(userVo);
        if (result)
            return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, ResponseEnum.GOOD.getMessage());
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.INTERNAL_SERVER_ERROR, ResponseEnum.FAIL.getMessage());
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        List<UserVo> users = adminService.getAllUsers();
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, CollectionUtils.isEmpty(users) ?
                Collections.emptyList() : users);
    }

    @PostMapping(value = "/addNewStore")
    public ResponseEntity<Object> addNewStore() {
        var storeVo = adminService.addNewStore();
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, storeVo);
    }
}
