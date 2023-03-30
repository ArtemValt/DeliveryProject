package com.bdcourse.bdcourse.service;


import com.bdcourse.bdcourse.model.vo.UserVo;
import lombok.NonNull;

public interface AdminService {
    boolean addUser(@NonNull UserVo user);
    boolean banUser(@NonNull UserVo user);
    boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate);
}
