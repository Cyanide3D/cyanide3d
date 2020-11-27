package com.defiant.cyanide3d.services;

import com.defiant.cyanide3d.dao.UserDao;
import com.defiant.cyanide3d.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    public void save(User user) {
        User newUser = new User(user.getPassword(), user.getUsername(), true, true, true, true, user.getNameuser(), user.getEmail());
        userDao.saveUser(newUser);
        userDao.saveUserRole("ROLE_USER", newUser);
        userDao.saveUserAvatar("DEFAULT_AVATAR", newUser);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User findUserByUsername(String username){
        return userDao.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userDao.findUserByUsername(username);
        return user == null ? new User(" ", " ", false, false, false, false, " ", " ") : user;
    }
}