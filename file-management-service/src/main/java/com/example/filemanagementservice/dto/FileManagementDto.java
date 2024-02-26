package com.example.filemanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileManagementDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String fileName;
    private String fileDesc;
    private String fileType;
    private String category;
    private Long size;
    private String originalName;
}
