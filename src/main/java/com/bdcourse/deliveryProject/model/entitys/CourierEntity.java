package com.bdcourse.deliveryProject.model.entitys;

import com.bdcourse.deliveryProject.jpa.abstractService.RepoEntity;
import com.bdcourse.deliveryProject.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "aaa_couriers")
public class CourierEntity implements RepoEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private Date startWorkDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal salary;
    @OneToOne
    @JoinColumn(name = "region_id")
    private RegionEntity regionEntity;
}