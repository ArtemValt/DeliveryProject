package com.bdcourse.bdcourse.model.entitys;

import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class HistoryDeliveryEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    @OneToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;
    @OneToOne
    @JoinColumn(name = "courier_id")
    CourierEntity courierEntity;
    @OneToMany
    @JoinColumn(name = "product_id")
    List<ElectronicEntity> entities;


}
