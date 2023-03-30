package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface UserDto extends JpaRepository<User, UUID> {

    @Modifying
    @Query(value = "insert into aaa_users (id,name,surname,rubles,password,email) "
            + " VALUES (:id,:name,:surname,:rubles,:password,:email)", nativeQuery = true)
    int addNewUser(@Param("id")String id,@Param("name") String name, @Param("surname") String surname,
                    @Param("rubles") BigDecimal rubles, @Param("password")
                    String password, @Param("email") String email);
}
