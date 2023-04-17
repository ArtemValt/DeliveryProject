package com.bdcourse.bdcourse.service.users.admin;


import lombok.NonNull;

import java.util.List;

public interface AdminService {
    boolean addUser(@NonNull UserVo user) throws Exception;
    boolean banUser(@NonNull UserVo user);
    boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate);
    List<UserVo> getAllUsers();
    StoreVo addNewStore();
}
