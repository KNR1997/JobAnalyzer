package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.UserPDF;
import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping(value = "/savePDF")
    public ResponseEntity<?> savePDF(@RequestParam("image") MultipartFile userPDF) throws IOException {
        String uploadImage = userService.savePDF(userPDF);
        return ResponseEntity.status(HttpStatus.OK).body(
                uploadImage
        );
    }

    @GetMapping(value = "/{fileName}")
    public ResponseEntity<?> downloadPDF(@PathVariable String fileName) throws IOException {
        byte[] fileData = userService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(fileData);
    }

}
