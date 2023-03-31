package com.bdcourse.bdcourse.service.users;

import com.bdcourse.bdcourse.helper.AppHelper;
import com.bdcourse.bdcourse.jpa.UserJpa;
import com.bdcourse.bdcourse.model.admin.Status;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.model.vo.UserVo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserJpa userJpaService;

    @Override
    public boolean addUser(@NonNull UserVo user) throws Exception {
        if(!AppHelper.checkEmail(user.getEmail())) return false;
        UserEntity userEntity = userJpaService.checkUserByEmailAndName(user.getEmail(), user.getName());
        if (Objects.nonNull(userEntity)) throw new Exception("Пользователь не найден");
        return userJpaService.addNewUser(user.getId(), user.getName(), user.getSurname(),
                user.getRubles(), user.getPassword(), user.getEmail(), Status.ACTIVE.getStatus()) == 1;

    }

    @Override
    public boolean banUser(@NonNull UserVo user) {
        return BooleanUtils.toBoolean(userJpaService.banUser(user.getEmail(),user.getName()));
    }

    @Override
    public boolean userUpdate(@NonNull UserVo userVo, UserStatisticUpdate userStatisticUpdate) {
        return false;
    }

    @Override
    public List<UserVo> getAllUsers() {
        List<UserVo> userVos = userJpaService.getAllUsers().stream().map(x -> new UserVo(x.getId(), x.getName(), x.getSurname(), x.getEmail(), x.getPassword(), x.getRubles())).toList();
        return userVos;
    }
}
