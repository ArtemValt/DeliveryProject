package com.bdcourse.bdcourse.web.Controller;


import com.bdcourse.bdcourse.bdcourseenums.ResponseEnum;
import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.model.vo.ProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import com.bdcourse.bdcourse.service.users.user.UserService;
import com.bdcourse.bdcourse.web.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user/service")
public class UserController extends ExceptionController {
    private final UserService userService;

    @GetMapping(value = "/getStores")
    public ResponseEntity getStores(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "address", required = false) String address) {
        List<StoreVo> stores = userService.getStores(name, address);
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, stores);
    }

    @PostMapping(value = "/byProductToUser")
    public ResponseEntity byProducts(@RequestParam(value = "name", required = false) String name) {
        userService.buyProduct(ProductVo.builder().productName(name).build());
        return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, "ALL GOOD");
    }

    @GetMapping(value = "/getUserProductByUserId")
    public ResponseEntity getUserProductByUserID() {
        String userId = SecurityHelper.getUserId();
        if (AppHelper.isValidUUID(userId)) {
            List<ProductVo> productsUser = userService.getProductsUser(userId);
            return ResponseHandler.generateResponse(ResponseEnum.GOOD, HttpStatus.OK, productsUser);
        }
        return ResponseHandler.generateResponse(ResponseEnum.FAIL, HttpStatus.BAD_REQUEST, "not valid id");
    }

}
