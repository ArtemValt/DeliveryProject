package com.bdcourse.bdcourse.helper;

import com.bdcourse.bdcourse.model.NameEntity;
import com.bdcourse.bdcourse.model.admin.UserEntity;
import com.bdcourse.bdcourse.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SecurityHelper {
    private static JwtService jwtService;

    @Autowired(required = true)
    public void setJwtService(JwtService jwtService) {
        SecurityHelper.jwtService = jwtService;
    }

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
