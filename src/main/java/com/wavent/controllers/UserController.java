package com.wavent.controllers;

import com.wavent.bean.User;
import com.wavent.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(method =  RequestMethod.POST)
    public User createUser(@RequestBody User user){
        this.userService.createUser(user);
        return this.userService.getUserById(user.getId());
    }

    @RequestMapping(method =  RequestMethod.GET)
    public List<User> getAllUser(){
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/id/{id}", method =  RequestMethod.GET)
    public User getUserById(@PathVariable String id){
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/mail/{mail:.+}", method =  RequestMethod.GET)
    public User getUserByMail(@PathVariable String mail){
        return this.userService.getUserByMail(mail);
    }

    @RequestMapping(value = "/auth", method =  RequestMethod.POST)
    public User authUse(@RequestBody User user){
        return this.userService.authentUser(user.getMail(), user.getPassword());
    }
}
