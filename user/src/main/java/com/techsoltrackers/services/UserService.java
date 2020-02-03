package com.techsoltrackers.services;

import com.techsoltrackers.domain.dto.User;

import java.util.List;

public interface UserService {
    User createUser(User user) ;
    List<User> getAllUsers();
    User getUserById(Long userId);
    User updateUser(Long userId, User userDetails);
    void deleteUser(Long userId);
}
