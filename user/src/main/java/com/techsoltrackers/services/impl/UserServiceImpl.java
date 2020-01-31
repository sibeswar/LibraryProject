package com.techsoltrackers.services.impl;

import com.techsoltrackers.domain.dto.User;
import com.techsoltrackers.persistance.dao.UserDAO;
import com.techsoltrackers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(Long userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        return userDAO.updateUser(userId,userDetails);
    }

    @Override
    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }
}
