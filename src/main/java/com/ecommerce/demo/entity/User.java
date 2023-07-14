package com.ecommerce.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userID;

    @Column(name = "USER_NAME")
    private String userName;

    @OneToMany(targetEntity = File.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER", referencedColumnName = "USER_ID")
    private List<File> files;

}
