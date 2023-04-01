package com.bdcourse.bdcourse.jpa;

import com.bdcourse.bdcourse.model.admin.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface AdminServiceJpa extends JpaRepository<UserEntity, UUID> {

    @Modifying
    @Query(value = "insert into aaa_users (id,name,surname,rubles,password,email,status) "
            + " VALUES (:id,:name,:surname,:rubles,:password,:email,:status)", nativeQuery = true)
    int addNewUser(@Param("id")String id,@Param("name") String name, @Param("surname") String surname,
                    @Param("rubles") BigDecimal rubles, @Param("password")
                    String password, @Param("email") String email,@Param("status")String status);
    @Query(value = "select u from UserEntity u where u.email =:email and u.name =:name")
    UserEntity checkUserByEmailAndName(@Param("email") String email, @Param("name") String name);
    @Query(value = "select u from UserEntity u where u.status = 'ACTIVE' ")
    List<UserEntity> getAllUsers();

    @Modifying
    @Query(value = "update UserEntity u set u.status =:status where 1=1 and u.email=:email and u.name =:name")
    int banUser(@Param("status")String status,@Param("email")String email,@Param("name")String name);
}
