package com.example.filemanagementservice.repository;

import com.example.filemanagementservice.model.FileManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FileManagementRepository extends JpaRepository<FileManagement, String> {
}
