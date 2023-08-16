package com.bdcourse.deliveryProject.helper;

import com.bdcourse.deliveryProject.model.entitys.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SecurityHelper {
    public static String getUserId() {
        var context = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(context)) {
            Object principal = context.getPrincipal();
            if (principal instanceof UserEntity)
                return ((UserEntity) principal).getId();
        }
        return StringUtils.EMPTY;
    }

}
