package com.example.LearningJava.service;

import com.example.LearningJava.entity.user.UserEntify;

import java.util.List;

public interface UserSevice {
    UserEntify createUser (UserEntify user);
    UserEntify findByUserNameAndEmail(String userName, String email);
}
