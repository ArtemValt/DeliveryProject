package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.NameEntity;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class UserVo implements NameEntity {
    private  String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final BigDecimal rubles;
}
