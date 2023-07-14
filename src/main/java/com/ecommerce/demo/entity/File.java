package com.ecommerce.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_file")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID")
    private Integer fileID;

    @Column(name = "FILE_NAME")
    private String name;

    @Column(name = "FILE_TYPE")
    private String type;

    @Column(name = "FILE_PATH")
    private String filePath;

}
