package com.example.demo.domain.service;

import com.example.demo.domain.model.FileUploadRecord;
import com.example.demo.domain.respository.FileUploadRecordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class FileUploadDomainService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileUploadRecordRepository fileUploadRecordRepository;

    public FileUploadDomainService(FileUploadRecordRepository fileUploadRecordRepository) {
        this.fileUploadRecordRepository = fileUploadRecordRepository;
    }

    public FileUploadRecord uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // 保存文件
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDir, fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        // 创建上传记录
        FileUploadRecord record = new FileUploadRecord();
        record.setFileName(fileName);
        record.setFilePath(path.toString());
        record.setUploadTime(LocalDateTime.now());

        // 保存上传记录
        fileUploadRecordRepository.save(record);

        return record;
    }
}