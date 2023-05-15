package com.bdcourse.bdcourse.model.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments_methods")
public class PaymentMethodsEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String cvv;
    @Column(unique = true)
    private String numCard;
    private Date expireDate;
    private BigDecimal sum;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    BankEntity bankEntity;

}
