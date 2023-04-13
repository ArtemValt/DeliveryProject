package com.bdcourse.bdcourse.model.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class CourierEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private Date startWorkDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
