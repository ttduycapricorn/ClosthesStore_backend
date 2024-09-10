package com.devteria.server.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User already exists"),
    USER_NOT_FOUND(1002, "User not found"),
    USERNAME_INVALID(1003, "Username is invalid"),
    PASSWORD_INVALID(1004, "User password must be at least 8 character and maximum length of 64"),
    EMAIL_INVALID(1005, "Email is invalid"),
    INVALID_KEY_EXCEPTION(1006, "invalid exception key"),
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized exception error"), //ngoại lệ không được phân loại
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
