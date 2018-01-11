package com.xinyou.bookstore.user.service.exception;

public class PasswordInsecureException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不安全！";
    }
}
