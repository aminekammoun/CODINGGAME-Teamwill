package com.yt.backend.service;
import com.yt.backend.model.Role;
import com.yt.backend.model.User;

import com.yt.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User updateUser(String email) {
        Optional<User> existingUserOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update the properties of the existing user based on the input user
            existingUser.setStatus(true);

            // Add other properties that you want to update

            return userRepository.save(existingUser);
        } else {
            return null; // User not found, return null to indicate the update failure
        }


}

    @Override
    public User updateScore(String email ,int score) {
        Optional<User> existingUserOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update the properties of the existing user based on the input user
            existingUser.setResultat(score);

            // Add other properties that you want to update

            return userRepository.save(existingUser);
        } else {
            return null; // User not found, return null to indicate the update failure
        }
    }
}
