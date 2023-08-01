package com.yt.backend.service;
import com.yt.backend.model.Role;
import com.yt.backend.model.User;

import com.yt.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get() ;
    }


    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> getCandidats(Role role) {return userRepository.findByRole(role);
    }


    @Override
    public void deleteUser(long id) {

        userRepository.deleteById(id);

    }


    @Override
    public User updateUser(User user) {
return userRepository.save(user) ;   }


}
