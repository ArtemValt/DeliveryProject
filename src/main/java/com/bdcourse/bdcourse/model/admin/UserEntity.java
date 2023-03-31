package com.bdcourse.bdcourse.model.admin;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "aaa_users")
public class UserEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String name;
    private String surname;
    private BigDecimal rubles;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
}
