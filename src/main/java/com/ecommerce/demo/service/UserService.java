package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.FileRepository;
import com.ecommerce.demo.dao.UserRepository;
import com.ecommerce.demo.entity.File;
import com.ecommerce.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    public UserService(UserRepository userRepository, FileRepository fileRepository) {
        this.userRepository = userRepository;
        this.fileRepository = fileRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<File> getUserFiles(String userId) {
        return fileRepository.findByUserID(userId);
    }

}
