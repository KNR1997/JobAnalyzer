package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Integer> {
    Optional<File> findByName(String fileName);
}
