package com.cvent.capstone.services;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.entities.User;
import com.cvent.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User updateUser(Long id, User updatedUser){
        User existingUser = this.findById(id);

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setImageUrl(updatedUser.getImageUrl());
        existingUser.setPan(updatedUser.getPan());
        existingUser.setExpiryMonth(updatedUser.getExpiryMonth());
        existingUser.setExpiryYear(updatedUser.getExpiryYear());
        existingUser.setRoles(updatedUser.getRoles());

        return userRepository.save(existingUser);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
