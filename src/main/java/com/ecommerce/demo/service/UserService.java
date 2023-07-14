package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.UserRepository;
import com.ecommerce.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private StorageService storageService;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public String savePDF(MultipartFile userPDF) throws IOException {
        storageService.uploadFileToFileSystem(userPDF);
        return null;
    }

    public byte[] downloadFile(String fileName) throws IOException {
        return storageService.downloadFile(fileName);
    }

    private void storageService(MultipartFile pdf, String userID) {
    }
}
