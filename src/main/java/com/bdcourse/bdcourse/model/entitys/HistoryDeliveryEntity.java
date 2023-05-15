package com.bdcourse.bdcourse.model.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_history")
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
