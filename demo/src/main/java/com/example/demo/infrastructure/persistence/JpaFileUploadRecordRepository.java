package com.example.demo.infrastructure.persistence;


import com.example.demo.domain.model.FileUploadRecord;
import com.example.demo.domain.respository.FileUploadRecordRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFileUploadRecordRepository extends FileUploadRecordRepository {
}