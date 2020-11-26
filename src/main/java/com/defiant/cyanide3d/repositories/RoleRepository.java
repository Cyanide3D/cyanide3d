package com.defiant.cyanide3d.repositories;

import com.defiant.cyanide3d.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByUserId(String userId);
}