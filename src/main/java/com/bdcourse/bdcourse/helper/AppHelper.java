package com.bdcourse.bdcourse.helper;

import com.bdcourse.bdcourse.model.NameEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class AppHelper {
    public static <T extends NameEntity> void setIdIfIdExist(T obj) {
        if (StringUtils.isBlank(obj.getId()))
            obj.setId(UUID.randomUUID().toString());
    }
}
