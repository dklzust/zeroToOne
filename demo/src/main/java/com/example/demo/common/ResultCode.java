package com.example.demo.common;



public enum ResultCode {
    SUCCESS(200, "Success"),
    FAIL(500, "Fail"),
    FILE_EMPTY(400, "File is empty"),
    UPLOAD_FAIL(500, "File upload failed");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
