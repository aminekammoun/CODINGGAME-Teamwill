package com.yt.backend.controller;

import com.yt.backend.model.User;
import com.yt.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:8081")
public class UserController {
    //service
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String hello_world(){
        return "Hello World";
    }
    //add Patient
    @PostMapping("/user/add")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User Added successfully..";
    }
    // getUserById
    @RequestMapping ("/user/{id}")
    public User getUserById(@PathVariable("id")long id){
        return userService.getUserById(id);
    }
    //getUsers
    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    //updateuser
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
    return userService.updateUser(user);}


    //deleteUserById
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "User Deleted ";
    }

}
