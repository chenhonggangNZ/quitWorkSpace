package com.xinyou.bookstore.user.service.exception;

public class UserNotExistException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在！";
    }
}
