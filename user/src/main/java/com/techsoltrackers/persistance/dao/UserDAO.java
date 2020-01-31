package com.techsoltrackers.persistance.dao;

import com.techsoltrackers.domain.dto.User;
import com.techsoltrackers.domain.entity.UserEntity;
import com.techsoltrackers.persistance.repository.UserRepository;
import com.techsoltrackers.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        UserEntity userEntity=ObjectMapperUtils.map(user,UserEntity.class);
        userEntity=userRepository.save(userEntity);
        User userRes=ObjectMapperUtils.map(userEntity,User.class);
        return userRes;
    }


    public List<User> getAllUsers() {
        List<UserEntity> userEntityList=userRepository.findAll();
        List<User> users=ObjectMapperUtils.mapAll(userEntityList,User.class);
        return users;
    }


    public User getUserById(Long userId) {
        UserEntity userEntity=userRepository.findById(userId).orElse(new UserEntity());
        User userRes=ObjectMapperUtils.map(userEntity,User.class);
        return userRes;
    }


    public User updateUser(Long userId, User userDetails) {
        User user=getUserById(userId);
        User userRes=null;
        if(user!=null){
            user.setUserName(userDetails.getUserName());
            UserEntity userEntity=ObjectMapperUtils.map(user,UserEntity.class);
            userEntity=userRepository.save(userEntity);
            userRes=ObjectMapperUtils.map(userEntity,User.class);
        }
        return userRes;
    }


    public void deleteUser(Long userId) {
        User user=getUserById(userId);
        if(user!=null) {
            UserEntity userEntity = ObjectMapperUtils.map(user, UserEntity.class);
            userRepository.delete(userEntity);
        }
    }
}
