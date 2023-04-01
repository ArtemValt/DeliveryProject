package com.bdcourse.bdcourse.model.stors;

import com.bdcourse.bdcourse.model.admin.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
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
    public StoreEntity(String id){
        this.id=id;
    }


}
