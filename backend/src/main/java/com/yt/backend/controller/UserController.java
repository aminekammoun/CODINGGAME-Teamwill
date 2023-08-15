package com.yt.backend.controller;

import com.yt.backend.model.Role;
import com.yt.backend.model.User;

import com.yt.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yt.backend.service.UserService;

import java.util.List;

import static com.yt.backend.model.Role.CANDIDAT;

@RestController
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

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
    @PutMapping("/user/{email}")
    public User updateUser(@PathVariable("email")String email){
    return userService.updateUser(email);}

    @PutMapping("score/{email}")
    public ResponseEntity<User> updateScore(@PathVariable String email, @RequestBody User user) {
        User updatedUser = userService.updateScore(email, user.getResultat());
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();}}

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
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
