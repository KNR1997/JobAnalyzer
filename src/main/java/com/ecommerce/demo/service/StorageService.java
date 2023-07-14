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
public class StorageService {

    private final FileRepository fileRepository;

    public StorageService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void uploadFileToFileSystem(MultipartFile file) throws IOException {

        String FOLDER_PATH = "C:\\Users\\Kethaka\\Documents\\MyFiles\\";
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        File fileData = fileRepository.save(File.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new java.io.File(filePath));

        file.getOriginalFilename();
    }

    public byte[] downloadFile(String fileName) throws IOException {
        Optional<File> fileData = fileRepository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        return Files.readAllBytes(new java.io.File(filePath).toPath());
    }
}
