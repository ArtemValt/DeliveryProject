package com.bdcourse.deliveryProject.helper;

import com.bdcourse.deliveryProject.bdcourseenums.RegexEnum;
import com.bdcourse.deliveryProject.model.NameEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Pattern;

public class AppHelper {
    public static <T extends NameEntity> void setIdIfIdExist(T obj) {
        if (StringUtils.isBlank(obj.getId()))
            obj.setId(UUID.randomUUID().toString());
    }

    public static boolean checkEmail(String email) {
        return Pattern.compile(RegexEnum.EMAIL_PATTERN.getPattern()).matcher(email).matches();
    }

    public static boolean isValidUUID(String uuid) {
        return Pattern.compile(RegexEnum.GUID_PATTERN.getPattern()).matcher(uuid).matches();
    }
}
