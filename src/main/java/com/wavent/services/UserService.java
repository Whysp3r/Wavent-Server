package com.wavent.services;

import com.wavent.bean.User;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
public interface UserService {

    User createUser(User user);

    User getUserById(String id);

    User getUserByMail(String mail);

    User authentUser(String mail, String password);

    List<User> getAllUsers();
}
