package com.bdcourse.bdcourse.model.entitys;

import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserProducts {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    @OneToOne
    @JoinColumn(name = "store_product_id")
    private ElectronicEntity electronicEntity;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private int count;

}
