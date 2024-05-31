package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;



import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "file_upload_record")
public class FileUploadRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    // Other fields if necessary
}
