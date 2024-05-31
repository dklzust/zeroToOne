package com.example.demo.interfaces.rest;

import com.example.demo.application.service.FileUploadService;
import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileUploadService.uploadFile(file);
    }
}
