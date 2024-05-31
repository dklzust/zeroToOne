package com.example.demo.application.service;

import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.domain.model.FileUploadRecord;
import com.example.demo.domain.service.FileUploadDomainService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    private final FileUploadDomainService fileUploadDomainService;

    public FileUploadService(FileUploadDomainService fileUploadDomainService) {
        this.fileUploadDomainService = fileUploadDomainService;
    }

    public Result<String> uploadFile(MultipartFile file) {
        try {
            FileUploadRecord record = fileUploadDomainService.uploadFile(file);
            return Result.success("文件上传成功：" + record.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(ResultCode.UPLOAD_FAIL, e.getMessage());
        } catch (IllegalArgumentException e) {
            return Result.error(ResultCode.FILE_EMPTY);
        }
    }
}