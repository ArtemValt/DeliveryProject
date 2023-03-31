package com.bdcourse.bdcourse.model.admin;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "aaa_adminusers")
public class AdminUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private String name;
    private String surname;
    private String countUsers;
    private String kikUsers;
    private String password;
    private String email;
}
