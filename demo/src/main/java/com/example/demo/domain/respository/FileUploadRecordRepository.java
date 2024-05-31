package com.example.demo.domain.respository;

import com.example.demo.domain.model.FileUploadRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRecordRepository extends JpaRepository<FileUploadRecord, Long> {
}