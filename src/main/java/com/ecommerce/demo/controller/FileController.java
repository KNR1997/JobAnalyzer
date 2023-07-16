package com.ecommerce.demo.controller;

import com.ecommerce.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("id") String userID,
                                        @RequestPart("file") MultipartFile file) throws IOException {
        String uploadImage = fileService.uploadFile(file, userID);
        return ResponseEntity.status(HttpStatus.OK).body(
                uploadImage
        );
    }

    @GetMapping(value = "/{fileName}")
    public ResponseEntity<?> downloadPDF(@PathVariable String fileName) throws IOException {
        byte[] fileData = fileService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(fileData);
    }
}
