package com.yt.backend.service;

import com.yt.backend.model.Role;
import com.yt.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User addUser (User user);
    public User getUserById(long id);
    public List<User> getUsers();
    public List<User> getCandidats(Role role);
    public void deleteUser(long id);
    public User updateUser (User user);


}
