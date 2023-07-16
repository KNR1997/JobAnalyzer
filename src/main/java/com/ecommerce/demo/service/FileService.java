package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.FileRepository;
import com.ecommerce.demo.entity.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@Transactional
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String uploadFile(MultipartFile file, String userID) throws IOException {

        String FOLDER_PATH = "C:\\Users\\Kethaka\\Documents\\MyFiles\\";
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        fileRepository.save(File.builder()
                .name(file.getOriginalFilename())
                .userID(userID)
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new java.io.File(filePath));

        file.getOriginalFilename();
        return FOLDER_PATH;
    }

    public byte[] downloadFile(String fileName) throws IOException {
        Optional<File> fileData = fileRepository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        return Files.readAllBytes(new java.io.File(filePath).toPath());
    }
}
