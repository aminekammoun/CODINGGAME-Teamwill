package com.yt.backend.controller;

import com.yt.backend.model.Role;
import com.yt.backend.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.yt.backend.service.UserService;

import java.util.List;

import static com.yt.backend.model.Role.CANDIDAT;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:8081")
public class UserController {

    @Autowired
    private UserService userService;


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

    @RequestMapping("/candidats/{role}")
    public List<User> getCandidats(@PathVariable("role")Role role){
        return userService.getCandidats(role);
    }
    //updateuser
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
    return userService.updateUser(user);}

    public String deleteToken(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "User Deleted ";
    }
    //deleteUserById
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "User Deleted ";
    }

}
