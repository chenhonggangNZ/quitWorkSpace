package com.xinyou.bookstore.user.service.exception;

public class UserAlreadyExistsException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在！";
    }
}
