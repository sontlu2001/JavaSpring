package com.example.LearningJava.service;

import com.example.LearningJava.entity.user.UserEntify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSevice {
    UserEntify createUser (UserEntify user);
    UserEntify findByUserNameAndEmail(String userName, String email);
    // get all by limit offset
    Page<UserEntify> findAllUsers(Pageable pageable);
    //get search by limit offset
    Page<UserEntify> findByUserName(String userName, Pageable pageable);

}
