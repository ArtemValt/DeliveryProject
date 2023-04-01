package com.bdcourse.bdcourse.model.products;

import com.bdcourse.bdcourse.model.stors.StoreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String productName;
    private BigDecimal price;
    private int countProducts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_position_id")
    StoreEntity store;

}
