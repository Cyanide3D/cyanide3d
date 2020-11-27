package com.defiant.cyanide3d.repositories;

import com.defiant.cyanide3d.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.username = :username, u.password = :password, u.nameuser = :nameuser, u.email = :email WHERE u.id=:id")
    int updateById(@Param("id") int id, @Param("username") String username, @Param("password") String password, @Param("nameuser") String nameuser, @Param("email") String email);
}