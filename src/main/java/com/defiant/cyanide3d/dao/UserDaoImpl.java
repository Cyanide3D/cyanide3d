package com.defiant.cyanide3d.dao;

import com.defiant.cyanide3d.models.Role;
import com.defiant.cyanide3d.models.User;
import com.defiant.cyanide3d.models.UserAvatar;
import com.defiant.cyanide3d.repositories.AvatarRepository;
import com.defiant.cyanide3d.repositories.RoleRepository;
import com.defiant.cyanide3d.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AvatarRepository avatarRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void saveUserRole(String role, User user){
        roleRepository.save(new Role(role,user));
    }

    public void saveUserAvatar(String avatarUrl, User user){
        avatarRepository.save(new UserAvatar(avatarUrl, user));
    }

    @Override
    public void update(User user) {
        userRepository.updateById(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<List> getAll() {
        return null;
    }
}
