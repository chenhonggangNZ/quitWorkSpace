package com.test.exception;

public class PasswordNotSafeException extends RegisterException {
    @Override
    public String getMessage() {
        return "您输入的密码过于简单";
    }
}
