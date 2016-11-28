package com.wavent.servicesImpl;

import com.wavent.bean.User;
import com.wavent.repository.UserRepository;
import com.wavent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.repository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return this.repository.findOne(id);
    }

    @Override
    public User getUserByMail(String mail) {
        return this.repository.findByMail(mail);
    }

    @Override
    public User authentUser(String mail, String password) {
        User userTotry = getUserByMail(mail);
        if( userTotry != null &&  passwordEncoder.matches(password,userTotry.getPassword())){
            return userTotry;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

}
