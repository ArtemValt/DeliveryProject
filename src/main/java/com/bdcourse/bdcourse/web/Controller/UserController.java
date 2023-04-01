package com.bdcourse.bdcourse.web.Controller;


import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import com.bdcourse.bdcourse.service.users.user.UserService;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user/service")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/getStores")
    public ResponseEntity getStores(@RequestParam(value = "name",required = false)String name,
                                    @RequestParam(value = "address",required = false) String address) {
        List<StoreVo> stores = userService.getStores(name, address);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, stores);
    }
}
