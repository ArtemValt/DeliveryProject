package com.bdcourse.deliveryProject.service.users.admin;


import com.bdcourse.deliveryProject.model.vo.StoreVo;
import com.bdcourse.deliveryProject.model.vo.UserVo;
import lombok.NonNull;

import java.util.List;

public interface AdminService {
    boolean banUser(@NonNull UserVo user);
    boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate);
    List<UserVo> getAllUsers();
    StoreVo addNewStore();
}
