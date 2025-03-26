package com.example.LearningJava.controller.user;

import com.example.LearningJava.entity.user.UserEntify;
import com.example.LearningJava.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping ("/getAll")
    public Page<UserEntify> getAll (
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order    
    ){
        Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(direction, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userSevice.findAllUsers(pageable);
    }

    @GetMapping ("/searchPage")
    public Page<UserEntify> searchPageUserName (
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam String userName
    ){
        Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(direction, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userSevice.findByUserName(userName, pageable);
    }
}
