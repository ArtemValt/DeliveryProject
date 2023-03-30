package com.bdcourse.bdcourse.web.Controller;

import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.service.AdminService;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping(value = "/addNewUser/addNewUser")
    public ResponseEntity<Object> addNewUser(@ModelAttribute() UserVo userVo) {
        AppHelper.setIdIfIdExist(userVo);
        boolean result = adminService.addUser(userVo);
        if (result) return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, true);
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.NO_CONTENT, false);
    }
}
