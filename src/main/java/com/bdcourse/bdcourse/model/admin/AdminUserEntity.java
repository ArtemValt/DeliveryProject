package com.bdcourse.bdcourse.model.admin;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
@Data
@Entity
@Table(name = "aaa_adminusers")
public class AdminUserEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String name;
    private String surname;
    private String countUsers;
    private String kikUsers;
    private String password;
    private String email;
}
