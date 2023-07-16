package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Integer> {
    Optional<File> findByName(String fileName);

    @Query("SELECT f FROM File f WHERE f.userID = :userId")
    List<File> findByUserID(String userId);
}
