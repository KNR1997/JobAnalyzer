package com.ecommerce.demo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserPDF {

    private String UserID;

    private MultipartFile PDF;

}
