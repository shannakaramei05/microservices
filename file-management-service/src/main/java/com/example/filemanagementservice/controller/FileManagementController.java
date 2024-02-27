package com.example.filemanagementservice.controller;

import com.example.filemanagementservice.services.FileManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/api")
public class FileManagementController {

    private FileManagementService fileManagementService;

    public FileManagementController(FileManagementService fileManagementService) {
        this.fileManagementService = fileManagementService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFileToServer(@RequestParam(value = "file")MultipartFile file, @RequestParam(value = "fileName") String fileName) {
        fileManagementService.saveFile(file,fileName);
        return ResponseEntity.ok("file already uploaded");
    }
}
