package com.bdcourse.bdcourse.service.imp;

import com.bdcourse.bdcourse.dto.UserDto;
import com.bdcourse.bdcourse.model.vo.UserVo;
import com.bdcourse.bdcourse.service.AdminService;
import com.bdcourse.bdcourse.service.UserStatisticUpdate;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserDto userDtoService;

    @Override
    public boolean addUser(@NonNull UserVo user) {
        return userDtoService.addNewUser(user.getId(), user.getName(), user.getSurname(),
                user.getRubles(), user.getPassword(), user.getEmail()) == 1;

    }

    @Override
    public boolean banUser(@NonNull UserVo user) {
        return false;
    }

    @Override
    public boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate) {
        return false;
    }


}
