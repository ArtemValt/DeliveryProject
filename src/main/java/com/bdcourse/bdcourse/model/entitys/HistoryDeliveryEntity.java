package com.bdcourse.bdcourse.model.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToOne
    @JoinColumn(name = "product_id")
    ProductEntity entities;


}
