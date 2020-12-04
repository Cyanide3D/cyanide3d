package com.defiant.cyanide3d.dao;

import com.defiant.cyanide3d.models.Role;
import com.defiant.cyanide3d.models.User;
import com.defiant.cyanide3d.repositories.RoleRepository;
import com.defiant.cyanide3d.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void saveUserRole(String role, User user){
        roleRepository.save(new Role(role,user));
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.updateById(user.getId(), user.getUsername(), user.getPassword(), user.getNameuser(), user.getEmail(), user.getAvatarurl());
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
