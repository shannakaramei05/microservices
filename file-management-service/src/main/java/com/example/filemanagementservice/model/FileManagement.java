package com.example.filemanagementservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_file")
public class FileManagement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileDesc;

    private String fileType;

    private String category;

    private Long size;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String uploadedFile;

    private boolean useYn;
}
