package com.bdcourse.bdcourse.model.entitys;

import com.bdcourse.bdcourse.bdcourseenums.RoleEnum;
import com.bdcourse.bdcourse.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String name;
    private String surname;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "varchar (255) default 'ACTIVE' ")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(columnDefinition = "varchar (255) default 'USER' ")
    @Enumerated(EnumType.STRING)
    RoleEnum roleEnum;
    @OneToOne
    @JoinColumn(name = "region_id")
    RegionEntity regionEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    List<AddressEntity> addressEntities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roleEnum.name()));
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    PaymentMethodsEntity paymentMethodsEntity;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
