package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.bdcourseenums.RoleEnum;
import com.bdcourse.bdcourse.model.NameEntity;
import com.bdcourse.bdcourse.model.admin.Status;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class UserVo implements NameEntity {
    private  String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final BigDecimal rubles;
    private final Status status;
    private final RoleEnum roleEnum;
}
