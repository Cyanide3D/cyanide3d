package com.defiant.cyanide3d.repositories;

import com.defiant.cyanide3d.models.UserAvatar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends CrudRepository<UserAvatar, Integer> {
}
