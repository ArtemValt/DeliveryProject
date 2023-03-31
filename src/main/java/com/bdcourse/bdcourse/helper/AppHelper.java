package com.bdcourse.bdcourse.helper;

import com.bdcourse.bdcourse.bdcourseenums.RegexEnum;
import com.bdcourse.bdcourse.model.NameEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Pattern;

public class AppHelper {

    public static <T extends NameEntity> void setIdIfIdExist(T obj) {
        if (StringUtils.isBlank(obj.getId()))
            obj.setId(UUID.randomUUID().toString());
    }
    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile(RegexEnum.EMAIL_PATTERN.getPattern());
        return pattern.matcher(email).matches();
    }
}
