package com.bdcourse.bdcourse.model.entitys;

import com.bdcourse.bdcourse.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
public class StoreEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String address;
    private String subjectProduct;
    private String storeName;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    List<ProductEntity> products;
    @OneToOne
    @JoinColumn(name = "region_id")
    RegionEntity regionEntity;


}
