package com.defiant.cyanide3d.services;

import com.defiant.cyanide3d.action.MailSender;
import com.defiant.cyanide3d.dao.UserDao;
import com.defiant.cyanide3d.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Autowired
    MailSender mailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        User newUser = new User(passwordEncoder.encode(user.getPassword()), user.getUsername(), true, true, true, true, user.getNameuser(), user.getEmail());
        mailSender.send("Регистрация на сайте Defiant'S.", "Вы успешно зарегистрировались на сайте!\nВаш логин: " + user.getUsername() + "\nВаш пароль: " + user.getPassword(), user.getEmail());
        newUser.setAvatarurl("https://cdn.discordapp.com/attachments/613894260152074240/783757562272415784/avatar_-_abstract_-_dribbble.webp");
        userDao.saveUser(newUser);
        userDao.saveUserRole("ROLE_USER", newUser);
    }

    public void update(User user) {
        User oldUser = findUserByUsername(user.getUsername());
        oldUser.setNameuser(user.getNameuser() == null?oldUser.getNameuser():user.getNameuser());
        oldUser.setAvatarurl(user.getAvatarurl() == null?oldUser.getAvatarurl():user.getAvatarurl());
        oldUser.setPassword(user.getPassword() == null?oldUser.getPassword():passwordEncoder.encode(user.getPassword()));
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