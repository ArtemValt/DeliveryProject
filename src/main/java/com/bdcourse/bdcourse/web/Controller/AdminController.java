package com.bdcourse.bdcourse.web.Controller;

import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.service.users.admin.AdminService;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/service")
public class AdminController {
    private final AdminService adminService;

    @PostMapping(value = "/addNewUser")
    public ResponseEntity<Object> addNewUser(@ModelAttribute UserVo userVo) throws Exception {
        AppHelper.setIdIfIdExist(userVo);
        boolean result = adminService.addUser(userVo);
        if (result) return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, true);
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.INTERNAL_SERVER_ERROR, ResponseEnum.FAIL.getMessage());
    }
    @PostMapping(value = "/banUser")
    public ResponseEntity<Object> banUser(@ModelAttribute UserVo userVo) {
        boolean result = adminService.banUser(userVo);
        if (result) return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, ResponseEnum.GOOD.getMessage());
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.INTERNAL_SERVER_ERROR, ResponseEnum.FAIL.getMessage());
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        List<UserVo> users = adminService.getAllUsers();
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, CollectionUtils.isEmpty(users) ?
                Collections.emptyList() : users);
    }
}
