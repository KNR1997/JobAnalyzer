package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.File;
import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser", consumes = "application/json")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping(value = "/getFiles/{userID}")
    public List<File> getUserFiles(@PathVariable("userID") String userID) {
        return userService.getUserFiles(userID);
    }

    @DeleteMapping(value = "/deleteFile/{fileID}")
    public void deleteUserId(@PathVariable Integer fileID) {
        userService.deleteUserFile(fileID);
    }

}
