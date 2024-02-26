package com.example.filemanagementservice.services;

import com.example.filemanagementservice.exceptions.FileStorageException;
import com.example.filemanagementservice.model.FileManagement;
import com.example.filemanagementservice.repository.FileManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Optional;

@Service
public class FileManagementService {

    private FileManagementRepository fileManagementRepository;

    private Path fileStorageLocation;

    public FileManagementService(FileManagementRepository fileManagementRepository) {
        this.fileManagementRepository = fileManagementRepository;
    }


    public String saveFile(MultipartFile file, String name) {
        FileManagement uploadFile = new FileManagement();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            uploadFile.setUploadedFile(Base64.getEncoder().encodeToString(file.getBytes()));
            uploadFile.setFileName(name);
            uploadFile.setSize(file.getSize());
            uploadFile.setFileType(file.getContentType());

            fileManagementRepository.save(uploadFile);

        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }

        return name + " already Upload";
    }

}
