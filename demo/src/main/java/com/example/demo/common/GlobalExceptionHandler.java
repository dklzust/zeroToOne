package com.example.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception e) {
        e.printStackTrace();
        return Result.error(ResultCode.FAIL, "服务器内部错误：" + e.getMessage());
    }
}
