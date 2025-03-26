package com.example.LearningJava.controller.user;

import com.example.LearningJava.entity.user.UserEntify;
import com.example.LearningJava.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/user")
public class UserController {
    @Autowired
    private UserSevice userSevice;

    @PostMapping("")
    public UserEntify createUser(@RequestBody UserEntify user){
        return userSevice.createUser(user);
    }

    @GetMapping ("/search")
    public UserEntify findByUserNameAndEmail(@RequestParam String userName, String email){
        return userSevice.findByUserNameAndEmail(userName, email);
    }
}
