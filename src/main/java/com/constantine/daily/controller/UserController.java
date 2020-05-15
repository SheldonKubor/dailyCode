package com.constantine.daily.controller;

import com.constantine.daily.domain.User;
import com.constantine.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public User getUsers(@RequestParam Integer id){
        User user = userService.getUser(id);
        return user;
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam Integer id){
        userService.deleteUser(id);
        return "ok";
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "ok";
    }


    @GetMapping("getAll")
    public List<User> getAll(){
        return userService.getALl();
    }
}
