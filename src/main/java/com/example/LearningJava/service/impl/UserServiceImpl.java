package com.example.LearningJava.service.impl;

import com.example.LearningJava.entity.user.UserEntify;
import com.example.LearningJava.repository.UserRepository;
import com.example.LearningJava.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserSevice {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntify createUser(UserEntify user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntify findByUserNameAndEmail(String userName, String email) {
        return userRepository.findByUserNameAndEmail(userName, email);
    }
}
